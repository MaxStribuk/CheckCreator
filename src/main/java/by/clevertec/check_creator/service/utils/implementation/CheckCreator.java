package by.clevertec.check_creator.service.utils.implementation;

import by.clevertec.check_creator.core.dto.OutputProductDTO;
import by.clevertec.check_creator.core.dto.ReceiptDTO;
import by.clevertec.check_creator.service.utils.api.ICheckCreator;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckCreator implements ICheckCreator {

    private final CostCalculator costCalculator;
    private static final String CHECK_HEADER = """
                       CASH RECEIPT
                     SUPERMARKET 123
               12, Milkyway Galaxy / Earth
                   Tel : 123-456-7890
               
               cashier: #1520    DATE: %s
                                 TIME: %s
              ___________________________________
              
              QTY   DESCRIPTION    PRICE    TOTAL
              
            """;
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String PRODUCT_PATTERN = "  %3d   %-11s   %6s   %6s\n";
    private static final String PROMOTIONAL_PRODUCT_PATTERN =
            "  Sale item, with discount %10s\n";
    private static final String TOTAL_PATTERN = """
              ___________________________________
              
              TOTAL%30s
            """;
    private static final String DISCOUNT_CARD_PATTERN = """

              Discount card %d, discount %9s
            """;

    public CheckCreator() {
        this.costCalculator = new CostCalculator();
    }

    @Override
    public String createHeader(ReceiptDTO check) {
        return String.format(CHECK_HEADER,
                check.getPurchaseTime()
                        .format(DateTimeFormatter.ofPattern(DATE_PATTERN)),
                check.getPurchaseTime()
                        .format(DateTimeFormatter.ofPattern(TIME_PATTERN)));
    }

    public String createBody(ReceiptDTO check) {
        StringBuilder body = new StringBuilder();
        List<OutputProductDTO> products = check.getProducts();
        for (OutputProductDTO product : products) {
            productPrinting(product, body);
        }
        return body.toString();
    }

    private void productPrinting(OutputProductDTO product, StringBuilder body) {
        int amount = product.getAmount();
        String title = product.getTitle();
        BigDecimal price = product.getPrice();
        BigDecimal total = costCalculator.calculateProductTotal(amount, price);
        body.append(String.format(PRODUCT_PATTERN,
                amount, title, "$" + price, "$" + total));
        boolean promotional = product.isPromotional();
        if (promotional && amount > 5) {
            total = costCalculator.calculateValueWithPromotionalDiscount(total);
            body.append(String.format(PROMOTIONAL_PRODUCT_PATTERN, "$" + total));
        }
        costCalculator.add(total);
    }

    public String createTotal(ReceiptDTO check) {
        StringBuilder stringTotal = new StringBuilder();
        if (check.getDiscountCard() != null
                && check.getDiscountCard().isActive()) {
            BigDecimal discount = costCalculator.calculateDiscountWithCard(
                    costCalculator.getTotal());
            stringTotal.append(String.format(DISCOUNT_CARD_PATTERN,
                    check.getDiscountCard().getId(), "$" + discount));
            costCalculator.subtract(discount);
        }
        stringTotal.append(String.format(
                TOTAL_PATTERN, "$" + costCalculator.getTotal()));
        return stringTotal.toString();
    }
}