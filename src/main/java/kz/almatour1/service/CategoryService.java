package kz.almatour1.service;

import kz.almatour1.dto.CategoryDTO;
import kz.almatour1.mapper.CategoryMapper;
import kz.almatour1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getCategories() {
        return categoryMapper.toDTOList(categoryRepository.findAll());
    }

    public CategoryDTO getCategoryById(Long id) {
        return categoryMapper.toDTO(categoryRepository.
                findById(id).
                orElse(null));
    }

    public void deletePlaceById(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO categoryDTO(CategoryDTO categoryDTO) {
        return categoryMapper.toDTO
                (categoryRepository.save(
                        categoryMapper.
                                toEntity(categoryDTO)));
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return categoryMapper.toDTO(categoryRepository.save(
                categoryMapper.toEntity(categoryDTO))
        );

    }


}
