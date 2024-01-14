package kz.almatour1.mapper;

import kz.almatour1.dto.CityDTO;
import kz.almatour1.model.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDTO cityDTO);

    CityDTO toDTO(City city);

    List<CityDTO> toDTOList(List<City> cities);

}
