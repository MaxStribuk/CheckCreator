package by.clevertec.check_creator.core.entity;

public class DiscountCardEntity {

    private final int id;
    private final boolean isActive;

    public DiscountCardEntity(int id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }
}