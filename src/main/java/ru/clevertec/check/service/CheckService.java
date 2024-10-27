package ru.clevertec.check.service;


import ru.clevertec.check.entity.Check;
import ru.clevertec.check.entity.Order;

public interface CheckService {

    Check createCheck(Order order);
}
