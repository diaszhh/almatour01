package kz.almatour1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String cardNumber;

    private String expirationDate;

    private String cvv;

    @ManyToOne
    private User user;
}
