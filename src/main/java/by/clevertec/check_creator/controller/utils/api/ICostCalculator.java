package by.clevertec.check_creator.controller.utils.api;

import java.math.BigDecimal;

public interface ICostCalculator {

    void add(BigDecimal value);
    void subtract(BigDecimal value);
    BigDecimal calculateProductTotal(int amount, BigDecimal price);
    BigDecimal calculateDiscountWithCard(BigDecimal value);
    BigDecimal calculateValueWithPromotionalDiscount(BigDecimal value);
}