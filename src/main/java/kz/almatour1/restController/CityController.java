package kz.almatour1.restController;

import kz.almatour1.dto.CityDTO;
import kz.almatour1.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/city")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityDTO> getPlaces() {
        return cityService.getCities();
    }

    @GetMapping(value = "/{id}")
    public CityDTO getCityById(@PathVariable(name = "id") Long id) {
        return cityService.getCityById(id);
    }

}
