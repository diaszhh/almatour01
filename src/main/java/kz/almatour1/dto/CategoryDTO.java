package kz.almatour1.dto;

import kz.almatour1.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO extends Category {
    private Long id;
    private String categoryName;
    
}
