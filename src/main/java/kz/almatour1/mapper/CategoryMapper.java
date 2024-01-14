package kz.almatour1.mapper;

import kz.almatour1.dto.CategoryDTO;
import kz.almatour1.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTOList(List<Category> categories);

}
