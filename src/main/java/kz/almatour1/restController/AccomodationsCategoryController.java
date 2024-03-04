package kz.almatour1.restController;

import kz.almatour1.dto.AccomodationDTO;
import kz.almatour1.service.CategoryService;
import kz.almatour1.service.AccomodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/place-category")
public class AccomodationsCategoryController {
    private final AccomodationService accomodationService;
    private final CategoryService categoryService;


    @PostMapping(value = "/add")
    public List<AccomodationDTO> addCategory(@RequestParam(name = "place_id") Long placeId,
                                             @RequestParam(name = "category_id", required = false, defaultValue = "0") Long categoryId) {
        accomodationService.assignCategory(placeId, categoryId);
        return accomodationService.getPlaces();
    }


    @PostMapping(value = "/remove")
    public List<AccomodationDTO> removeCategory(@RequestParam(name = "place_id") Long placeId,
                                                @RequestParam(name = "category_id", required = false, defaultValue = "0") Long categoryId) {
        accomodationService.removeCategory(placeId, categoryId);
        return accomodationService.getPlaces();
    }
}
