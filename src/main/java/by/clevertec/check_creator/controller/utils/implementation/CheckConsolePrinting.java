package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.OutputProductDTO;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckConsolePrinting implements ICheckPrinting {

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
            "  Товар на акции, со скидкой %8s\n";
    private static final String TOTAL_PATTERN = """
              ___________________________________
              
              TOTAL%30.4s
            """;
    private static final String DISCOUNT_CARD_PATTERN = """

              Скидочная карта №%d,скидка %9s
            """;

    public CheckConsolePrinting() {
        this.costCalculator = new CostCalculator();
    }

    @Override
    public void printCheck(CheckDTO check) {
        headerPrinting(check);
        bodyPrinting(check);
        totalPrinting(check);
    }

    private void headerPrinting(CheckDTO check) {
        System.out.printf(CHECK_HEADER,
                check.getPurchaseTime()
                        .format(DateTimeFormatter.ofPattern(DATE_PATTERN)),
                check.getPurchaseTime()
                        .format(DateTimeFormatter.ofPattern(TIME_PATTERN)));
    }

    private void bodyPrinting(CheckDTO check) {
        List<OutputProductDTO> products = check.getProducts();
        for (OutputProductDTO product : products) {
            productPrinting(product);
        }
    }

    private void productPrinting(OutputProductDTO product) {
        int amount = product.getAmount();
        String title = product.getTitle();
        BigDecimal price = product.getPrice();
        BigDecimal total = costCalculator.calculateProductTotal(amount, price);
        System.out.printf(PRODUCT_PATTERN,
                amount, title, "$" + price, "$" + total);
        boolean promotional = product.isPromotional();
        if (promotional && amount > 5) {
            total = costCalculator.calculateValueWithPromotionalDiscount(total);
            System.out.printf(PROMOTIONAL_PRODUCT_PATTERN, "$" + total);
        }
        costCalculator.add(total);
    }

    private void totalPrinting(CheckDTO check) {
        if (check.getDiscountCard() != null
                && check.getDiscountCard().isActive()) {
            BigDecimal discount = costCalculator.calculateDiscountWithCard(
                    costCalculator.getTotal());
            System.out.printf(DISCOUNT_CARD_PATTERN,
                    check.getDiscountCard().getId(), "$" + discount);
            costCalculator.subtract(discount);
        }
        System.out.printf(TOTAL_PATTERN, "$" + costCalculator.getTotal());
    }
}