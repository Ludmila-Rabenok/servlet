package ru.clevertec.check.dto;

import java.util.Objects;

public class DiscountCardDto {
    private int id;
    private int number;
    private int discountAmount;

    public DiscountCardDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCardDto that = (DiscountCardDto) o;
        return getId() == that.getId() &&
                getNumber() == that.getNumber() &&
                getDiscountAmount() == that.getDiscountAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getDiscountAmount());
    }

    @Override
    public String toString() {
        return "DiscountCardDto{" +
                "id=" + id +
                ", number=" + number +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
