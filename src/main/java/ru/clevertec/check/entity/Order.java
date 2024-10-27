package ru.clevertec.check.entity;

import java.util.Map;
import java.util.Objects;

public class Order {

    private Map<Integer, Integer> productIdAndQuantityMap;
    private DiscountCard discountCard;
    private Double balanceDebitCard;

    public Order(OrderBuilder orderBuilder) {
        this.productIdAndQuantityMap = orderBuilder.productIdAndQuantityMap;
        this.discountCard = orderBuilder.discountCard;
        this.balanceDebitCard = orderBuilder.balanceDebitCard;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public Map<Integer, Integer> getProductIdAndQuantityMap() {
        return productIdAndQuantityMap;
    }

    public Double getBalanceDebitCard() {
        return balanceDebitCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getProductIdAndQuantityMap(), order.getProductIdAndQuantityMap()) &&
                Objects.equals(getDiscountCard(), order.getDiscountCard()) &&
                Objects.equals(getBalanceDebitCard(), order.getBalanceDebitCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductIdAndQuantityMap(), getDiscountCard(), getBalanceDebitCard());
    }

    @Override
    public String toString() {
        return "Order{" +
                "productAndQuantityMap=" + productIdAndQuantityMap +
                ", discountCard=" + discountCard +
                ", balanceDebitCard=" + balanceDebitCard +
                '}';
    }
}
