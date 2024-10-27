package ru.clevertec.check.service;

import ru.clevertec.check.entity.Order;

import java.util.Map;

public interface OrderService {

    Order createOrder(Map<Integer,Integer> map, int numberCard, double balance);
}
