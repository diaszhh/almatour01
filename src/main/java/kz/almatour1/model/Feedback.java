package kz.almatour1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String comment;

    private int rating;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

}
