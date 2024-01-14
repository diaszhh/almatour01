package kz.almatour1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "event_name")
    private String eventName;

    private String description;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @ManyToOne
    private Place place;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @ManyToOne
    private Customer customer;
}
