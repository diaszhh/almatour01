package kz.almatour1.restController;

import kz.almatour1.dto.PlaceDTO;
import kz.almatour1.service.CategoryService;
import kz.almatour1.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/place-category")
public class PlaceCategoryController {
    private final PlaceService placeService;
    private final CategoryService categoryService;


    @PostMapping(value = "/add")
    public List<PlaceDTO> addCategory(@RequestParam(name = "place_id") Long placeId,
                                      @RequestParam(name = "category_id", required = false, defaultValue = "0") Long categoryId) {
        placeService.assignCategory(placeId, categoryId);
        return placeService.getPlaces();
    }


    @PostMapping(value = "/remove")
    public List<PlaceDTO> removeCategory(@RequestParam(name = "place_id") Long placeId,
                                         @RequestParam(name = "category_id", required = false, defaultValue = "0") Long categoryId) {
        placeService.removeCategory(placeId, categoryId);
        return placeService.getPlaces();
    }
}
