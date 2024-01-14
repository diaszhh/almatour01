package kz.almatour1.mapper;


import kz.almatour1.dto.PlaceDTO;
import kz.almatour1.model.Place;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PlaceMapper {
    Place toEntity(PlaceDTO placeDTO);

    PlaceDTO toDTO(Place place);

    List<PlaceDTO> toDTOList(List<Place> places);
}
