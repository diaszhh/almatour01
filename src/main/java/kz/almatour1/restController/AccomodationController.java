package kz.almatour1.restController;

import kz.almatour1.dto.AccomodationDTO;
import kz.almatour1.service.AccomodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accomodations")
public class AccomodationController {

    private final AccomodationService accomodationService;

    @GetMapping
    public List<AccomodationDTO> getPlaces() {
        return accomodationService.getPlaces();
    }

    @GetMapping(value = "/{id}")
    public AccomodationDTO getPlaceById(@PathVariable(name = "id") Long id) {
        return accomodationService.getPlaceById(id);
    }

    @PostMapping(value = "/add")
    public AccomodationDTO addPlace(@RequestBody AccomodationDTO place) {
        return accomodationService.addPlace(place);
    }

    @PutMapping(value = "/update")
    public AccomodationDTO updatePlace(@RequestBody AccomodationDTO place) {
        return accomodationService.updatePlace(place);
    }

    @PostMapping(value = "/delete-{id}")
    public void deletePlace(@PathVariable(name = "id") Long id) {
        accomodationService.deletePlaceById(id);
    }
}
