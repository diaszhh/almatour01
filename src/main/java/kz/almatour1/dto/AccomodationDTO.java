package kz.almatour1.dto;

import kz.almatour1.model.Category;
import kz.almatour1.model.City;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class AccomodationDTO {
    private Long id;
    private String name;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private boolean isStatus;
    private City city;
}
