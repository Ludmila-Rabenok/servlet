package ru.clevertec.check.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.check.dto.DiscountCardDto;
import ru.clevertec.check.entity.DiscountCard;

@Mapper
public interface DiscountCardMapper {
    DiscountCardMapper INSTANCE = Mappers.getMapper(DiscountCardMapper.class);

    DiscountCardDto toDiscountCardDto(DiscountCard discountCard);

    DiscountCard toDiscountCard(DiscountCardDto discountCardDto);
}