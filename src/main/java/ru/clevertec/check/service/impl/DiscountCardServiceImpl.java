package ru.clevertec.check.service.impl;

import ru.clevertec.check.dto.DiscountCardDto;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.mapper.DiscountCardMapper;
import ru.clevertec.check.repository.DB.DiscountCardRepository;
import ru.clevertec.check.service.DiscountCardService;

public class DiscountCardServiceImpl implements DiscountCardService {
    private final DiscountCardRepository discountCardRepository;

    public DiscountCardServiceImpl(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public DiscountCardDto create(DiscountCardDto discountCardDto) {
        DiscountCard discountCard = DiscountCardMapper.INSTANCE.toDiscountCard(discountCardDto);
        return DiscountCardMapper.INSTANCE.toDiscountCardDto(discountCardRepository.create(discountCard));
    }

    @Override
    public DiscountCardDto getByNumber(int number) {
        return DiscountCardMapper.INSTANCE.toDiscountCardDto(discountCardRepository.readByNumber(number));
    }

    @Override
    public DiscountCardDto getById(int id) {
        return DiscountCardMapper.INSTANCE.toDiscountCardDto(discountCardRepository.readById(id));
    }

    @Override
    public boolean update(DiscountCardDto discountCardDto) {
        DiscountCard discountCard = DiscountCardMapper.INSTANCE.toDiscountCard(discountCardDto);
        return discountCardRepository.update(discountCard);
    }

    @Override
    public boolean delete(int id) {
        return discountCardRepository.remove(id);
    }
}
