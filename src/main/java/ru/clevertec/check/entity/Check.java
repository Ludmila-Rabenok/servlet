package ru.clevertec.check.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Check {
    private LocalDate date;
    private LocalTime time;
    private Order order;
    private List<Position> positions;
    private double totalPrice;
    private double totalDiscount;
    private double totalWithDiscount;

    public Check(CheckBuilder checkBuilder) {
        date = LocalDate.now();
        time = LocalTime.now();
        this.order = checkBuilder.order;
        this.positions = checkBuilder.positions;
        this.totalPrice = checkBuilder.totalPrice;
        this.totalDiscount = checkBuilder.totalDiscount;
        this.totalWithDiscount = checkBuilder.totalWithDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Order getOrder() {
        return order;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Double.compare(check.getTotalPrice(), getTotalPrice()) == 0 &&
                Double.compare(check.getTotalDiscount(), getTotalDiscount()) == 0 &&
                Double.compare(check.getTotalWithDiscount(), getTotalWithDiscount()) == 0 &&
                Objects.equals(getDate(), check.getDate()) &&
                Objects.equals(getTime(), check.getTime()) &&
                Objects.equals(getOrder(), check.getOrder()) &&
                Objects.equals(getPositions(), check.getPositions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTime(), getOrder(), getPositions(), getTotalPrice(), getTotalDiscount(), getTotalWithDiscount());
    }

    @Override
    public String toString() {
        return "Check{" +
                "date=" + date +
                ", time=" + time +
                ", order=" + order +
                ", positions=" + positions +
                ", totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", totalWithDiscount=" + totalWithDiscount +
                '}';
    }
}
