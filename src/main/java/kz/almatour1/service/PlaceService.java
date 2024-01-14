package kz.almatour1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kz.almatour1.dto.CategoryDTO;
import kz.almatour1.dto.PlaceDTO;
import kz.almatour1.mapper.CategoryMapper;
import kz.almatour1.mapper.PlaceMapper;
import kz.almatour1.model.Category;
import kz.almatour1.model.Place;
import kz.almatour1.repository.CategoryRepository;
import kz.almatour1.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PlaceService {
    @PersistenceContext
    private EntityManager entityManager;
    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final PlaceMapper placeMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    public List<PlaceDTO> getPlaces() {
        return placeMapper.toDTOList(placeRepository.findAll());
    }

    public PlaceDTO getPlaceById(Long id) {
        return placeMapper.toDTO(placeRepository.
                findById(id).
                orElse(null));
    }

    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    public PlaceDTO addPlace(PlaceDTO placeDTO) {
        // Маппинг DTO в сущность
        Place place = placeMapper.toEntity(placeDTO);

        // Сохранение сущности
        place = placeRepository.save(place);

        // Маппинг сущности обратно в DTO (вам может понадобиться добавить этот метод в ваш PlaceMapper)
        return placeMapper.toDTO(place);
    }


    public PlaceDTO updatePlace(PlaceDTO place) {
        return placeMapper.toDTO(placeRepository.save(
                placeMapper.toEntity(place))
        );
    }

    @Transactional
    public void assignCategory(Long placeId, Long categoryId) {
        PlaceDTO placeDTO = getPlaceById(placeId);
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);

        // Маппинг DTO в сущности
        Place place = placeMapper.toEntity(placeDTO);
        Category category = categoryMapper.toEntity(categoryDTO);

        // Проверка, что маппинг прошел корректно и сущности не являются null
        if (place != null && category != null && !place.getCategories().contains(category)) {
            // Если категория новая, то сохраняем ее в базу данных
            if (category.getId() == null) {
                category = categoryRepository.save(category);
            }

            // Добавление категории к месту и сохранение места
            place.getCategories().add(category);
            placeRepository.save(place);
        }
    }

    @Transactional
    public void removeCategory(Long placeId, Long categoryId) {
        PlaceDTO placeDTO = getPlaceById(placeId);
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);

        // Маппинг DTO в сущности
        Place place = placeMapper.toEntity(placeDTO);
        Category category = categoryMapper.toEntity(categoryDTO);

        // Логирование перед удалением
        System.out.println("Before removal: " + place.getCategories());

        // Проверка, что маппинг прошел корректно и сущности не являются null
        if (place != null && category != null && place.getCategories().contains(category)) {
            place.getCategories().remove(category);

            entityManager.merge(place);

            System.out.println("After removal: " + place.getCategories());
        }

    }


}