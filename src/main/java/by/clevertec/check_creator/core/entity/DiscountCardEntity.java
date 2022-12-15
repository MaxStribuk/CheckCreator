package by.clevertec.check_creator.core.entity;

public class DiscountCardEntity {

    private final int number;
    private final boolean isActive;

    public DiscountCardEntity(int number, boolean isActive) {
        this.number = number;
        this.isActive = isActive;
    }

    public int getNumber() {
        return number;
    }

    public boolean isActive() {
        return isActive;
    }
}