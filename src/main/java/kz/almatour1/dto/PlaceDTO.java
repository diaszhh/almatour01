package kz.almatour1.dto;

import kz.almatour1.model.Category;
import kz.almatour1.model.City;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaceDTO {
    private Long id;

    private String name;

    private String description;

    private int money;

    private String localTime;

    private String imageUrl;
    private List<Category> categories;
    private City city;
}
