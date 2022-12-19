package by.clevertec.check_creator.core.dto;

public class CheckDTO {

    private final String head;
    private final String body;
    private final String total;

    public CheckDTO(String head, String body, String total) {
        this.head = head;
        this.body = body;
        this.total = total;
    }

    @Override
    public String toString() {
        return head + body + total;
    }
}