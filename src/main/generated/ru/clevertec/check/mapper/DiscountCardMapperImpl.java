package ru.clevertec.check.mapper;

import javax.annotation.Generated;
import ru.clevertec.check.dto.DiscountCardDto;
import ru.clevertec.check.entity.DiscountCard;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T19:22:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class DiscountCardMapperImpl implements DiscountCardMapper {

    @Override
    public DiscountCardDto toDiscountCardDto(DiscountCard discountCard) {
        if ( discountCard == null ) {
            return null;
        }

        DiscountCardDto discountCardDto = new DiscountCardDto();

        discountCardDto.setId( discountCard.getId() );
        discountCardDto.setNumber( discountCard.getNumber() );
        discountCardDto.setDiscountAmount( discountCard.getDiscountAmount() );

        return discountCardDto;
    }

    @Override
    public DiscountCard toDiscountCard(DiscountCardDto discountCardDto) {
        if ( discountCardDto == null ) {
            return null;
        }

        DiscountCard discountCard = new DiscountCard();

        discountCard.setId( discountCardDto.getId() );
        discountCard.setNumber( discountCardDto.getNumber() );
        discountCard.setDiscountAmount( discountCardDto.getDiscountAmount() );

        return discountCard;
    }
}
