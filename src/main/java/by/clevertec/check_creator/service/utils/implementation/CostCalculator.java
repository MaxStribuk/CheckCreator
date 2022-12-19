package by.clevertec.check_creator.service.utils.implementation;

import by.clevertec.check_creator.service.utils.api.ICostCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostCalculator implements ICostCalculator {

    private BigDecimal total;
    private static final int cardDiscount = 10;
    private static final int promotionalDiscount = 10;
    private static final int ONE_HUNDRED_PERCENT = 100;

    public BigDecimal getTotal() {
        return total;
    }

    public CostCalculator() {
        this.total = BigDecimal.ZERO
                .setScale(2, RoundingMode.HALF_UP );
    }

    @Override
    public void add(BigDecimal value) {
        total = total.add(value);
    }

    @Override
    public void subtract(BigDecimal value) {
        total = total.subtract(value);
    }

    @Override
    public BigDecimal calculateProductTotal(int amount, BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(amount));
    }

    @Override
    public BigDecimal calculateValueWithPromotionalDiscount(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(
                        (ONE_HUNDRED_PERCENT - promotionalDiscount) * 1. / ONE_HUNDRED_PERCENT))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateDiscountWithCard(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(
                        cardDiscount * 1. / ONE_HUNDRED_PERCENT))
                .setScale(2, RoundingMode.HALF_UP);
    }
}