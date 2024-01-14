package kz.almatour1.service;

import kz.almatour1.dto.CityDTO;
import kz.almatour1.mapper.CityMapper;
import kz.almatour1.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityDTO> getCities() {
        return cityMapper.toDTOList(cityRepository.findAll());
    }

    public CityDTO getCityById(Long id) {
        return cityMapper.toDTO(cityRepository.
                findById(id).
                orElse(null));
    }

}
