package by.clevertec.check_creator.core.dto;

public class CheckDTO {

    private final String header;
    private final String body;
    private final String total;

    public CheckDTO(String header, String body, String total) {
        this.header = header;
        this.body = body;
        this.total = total;
    }

    @Override
    public String toString() {
        return header + body + total;
    }
}