package kz.almatour1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Accomodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private boolean isStatus = false;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @ManyToOne
    private City city;


    @ManyToOne
    private User user;
}
