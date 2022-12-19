package by.clevertec.check_creator.core.dto;

import java.math.BigDecimal;

public class OutputProductDTO {

    private final String title;
    private final int amount;
    private final boolean isPromotional;
    private final BigDecimal price;

    private OutputProductDTO(String title, int amount, boolean isPromotional,
                            BigDecimal price) {
        this.title = title;
        this.amount = amount;
        this.isPromotional = isPromotional;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static class OutputProductBuilder {

        private String title;
        private int amount;
        private boolean isPromotional;
        private BigDecimal price;

        private OutputProductBuilder() {
        }

        public static OutputProductBuilder create(){
            return new OutputProductBuilder();
        }

        public OutputProductBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public OutputProductBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public OutputProductBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OutputProductBuilder setIsPromotional(boolean isPromotional) {
            this.isPromotional = isPromotional;
            return this;
        }

        public OutputProductDTO build(){
            return new OutputProductDTO(title, amount, isPromotional, price);
        }
    }
}