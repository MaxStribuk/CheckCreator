package by.clevertec.check_creator.core.dto;

public class InputProductDTO {

    private final int id;
    private final int amount;

    public InputProductDTO(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}