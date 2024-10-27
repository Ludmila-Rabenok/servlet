package ru.clevertec.check.entity;

import java.util.Objects;

public class Position {

    private Product product;
    private int quantity;
    private double totalPricePosition;
    private double discountPosition;

    public Position(Product product, int quantity, double totalPricePosition, double discountPosition) {
        this.product = product;
        this.quantity = quantity;
        this.totalPricePosition = totalPricePosition;
        this.discountPosition = discountPosition;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPricePosition() {
        return totalPricePosition;
    }

    public double getDiscountPosition() {
        return discountPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getQuantity() == position.getQuantity() &&
                Double.compare(position.getTotalPricePosition(), getTotalPricePosition()) == 0 &&
                Double.compare(position.getDiscountPosition(), getDiscountPosition()) == 0 &&
                Objects.equals(getProduct(), position.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getQuantity(), getTotalPricePosition(), getDiscountPosition());
    }

    @Override
    public String toString() {
        return "Position{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", totalPricePosition=" + totalPricePosition +
                ", discountPosition=" + discountPosition +
                '}';
    }
}
