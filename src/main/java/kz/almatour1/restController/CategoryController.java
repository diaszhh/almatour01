package kz.almatour1.restController;

import kz.almatour1.dto.CategoryDTO;
import kz.almatour1.model.Category;
import kz.almatour1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

}
