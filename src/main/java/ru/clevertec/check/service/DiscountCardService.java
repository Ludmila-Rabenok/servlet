package ru.clevertec.check.service;


import ru.clevertec.check.dto.DiscountCardDto;

public interface DiscountCardService {

    DiscountCardDto create(DiscountCardDto discountCardDto);

    DiscountCardDto getByNumber(int number);

    DiscountCardDto getById(int id);

    boolean update(DiscountCardDto discountCardDto);

    boolean delete(int id);
}
