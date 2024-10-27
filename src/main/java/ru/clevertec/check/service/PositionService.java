package ru.clevertec.check.service;

import ru.clevertec.check.entity.Position;

import java.util.List;

public interface PositionService {

    Position create(int productId, int quantity, int percentDiscountCard);

    int changeQuantityOfProductsInStock(List<Position> positions);
}
