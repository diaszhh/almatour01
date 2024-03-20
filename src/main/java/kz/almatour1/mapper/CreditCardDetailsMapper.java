package kz.almatour1.mapper;

import kz.almatour1.dto.CreditCardDetailsDTO;
import kz.almatour1.model.CreditCardDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditCardDetailsMapper {

    @Mapping(source = "userId", target = "user.id")
    CreditCardDetails toEntity(CreditCardDetailsDTO creditCardDetailsDTO);
    @Mapping(source = "user.id", target = "userId")
    CreditCardDetailsDTO toDTO(CreditCardDetails creditCardDetails);

    List<CreditCardDetailsDTO> toDTOList(List<CreditCardDetails> creditCardDetails);

}
