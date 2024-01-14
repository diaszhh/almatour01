package kz.almatour1.restController;

import kz.almatour1.dto.PlaceDTO;
import kz.almatour1.mapper.PlaceMapper;
import kz.almatour1.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/place")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getPlaces() {
        return placeService.getPlaces();
    }

    @GetMapping(value = "/{id}")
    public PlaceDTO getPlaceById(@PathVariable(name = "id") Long id) {
        return placeService.getPlaceById(id);
    }

    @PostMapping(value = "/add")
    public PlaceDTO addPlace(@RequestBody PlaceDTO place) {
        return placeService.addPlace(place);
    }

    @PutMapping(value = "/update")
    public PlaceDTO updatePlace(@RequestBody PlaceDTO place) {
        return placeService.updatePlace(place);
    }

    @PostMapping(value = "/delete-{id}")
    public void deletePlace(@PathVariable(name = "id") Long id) {
        placeService.deletePlaceById(id);
    }
}
