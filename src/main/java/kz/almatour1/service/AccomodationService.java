package kz.almatour1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kz.almatour1.dto.CategoryDTO;
import kz.almatour1.dto.AccomodationDTO;
import kz.almatour1.mapper.CategoryMapper;
import kz.almatour1.mapper.AccomodationMapper;
import kz.almatour1.model.Category;
import kz.almatour1.model.Accomodation;
import kz.almatour1.repository.CategoryRepository;
import kz.almatour1.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccomodationService {
    @PersistenceContext
    private EntityManager entityManager;
    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final AccomodationMapper accomodationMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    public List<AccomodationDTO> getPlaces() {
        return accomodationMapper.toDTOList(placeRepository.findAll());
    }

    public AccomodationDTO getPlaceById(Long id) {
        return accomodationMapper.toDTO(placeRepository.
                findById(id).
                orElse(null));
    }

    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    public AccomodationDTO addPlace(AccomodationDTO accomodationDTO) {
        // Маппинг DTO в сущность
        Accomodation accomodation = accomodationMapper.toEntity(accomodationDTO);

        // Сохранение сущности
        accomodation = placeRepository.save(accomodation);

        // Маппинг сущности обратно в DTO (вам может понадобиться добавить этот метод в ваш PlaceMapper)
        return accomodationMapper.toDTO(accomodation);
    }


    public AccomodationDTO updatePlace(AccomodationDTO place) {
        return accomodationMapper.toDTO(placeRepository.save(
                accomodationMapper.toEntity(place))
        );
    }

    @Transactional
    public void assignCategory(Long placeId, Long categoryId) {
        AccomodationDTO accomodationDTO = getPlaceById(placeId);
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);

        // Маппинг DTO в сущности
        Accomodation accomodation = accomodationMapper.toEntity(accomodationDTO);
        Category category = categoryMapper.toEntity(categoryDTO);

        // Проверка, что маппинг прошел корректно и сущности не являются null
        if (accomodation != null && category != null && !accomodation.getCategories().contains(category)) {
            // Если категория новая, то сохраняем ее в базу данных
            if (category.getId() == null) {
                category = categoryRepository.save(category);
            }

            // Добавление категории к месту и сохранение места
            accomodation.getCategories().add(category);
            placeRepository.save(accomodation);
        }
    }

    @Transactional
    public void removeCategory(Long placeId, Long categoryId) {
        AccomodationDTO accomodationDTO = getPlaceById(placeId);
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);

        // Маппинг DTO в сущности
        Accomodation accomodation = accomodationMapper.toEntity(accomodationDTO);
        Category category = categoryMapper.toEntity(categoryDTO);

        // Логирование перед удалением
        System.out.println("Before removal: " + accomodation.getCategories());

        // Проверка, что маппинг прошел корректно и сущности не являются null
        if (accomodation != null && category != null && accomodation.getCategories().contains(category)) {
            accomodation.getCategories().remove(category);

            entityManager.merge(accomodation);

            System.out.println("After removal: " + accomodation.getCategories());
        }

    }


}