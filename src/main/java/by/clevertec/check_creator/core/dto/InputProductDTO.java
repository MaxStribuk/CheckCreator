package by.clevertec.check_creator.core.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputProductDTO that = (InputProductDTO) o;
        return id == that.id && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}