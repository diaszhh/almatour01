package kz.almatour1.mapper;


import kz.almatour1.dto.AccomodationDTO;
import kz.almatour1.model.Accomodation;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccomodationMapper {
    Accomodation toEntity(AccomodationDTO accomodationDTO);

    AccomodationDTO toDTO(Accomodation accomodation);

    List<AccomodationDTO> toDTOList(List<Accomodation> accomodations);
}
