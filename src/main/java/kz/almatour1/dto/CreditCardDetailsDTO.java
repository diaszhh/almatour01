package kz.almatour1.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetailsDTO {
    private Long id;

    private String fullName;

    private String cardNumber;

    private String expirationDate;

    private String cvv;

    private Long userId;

}
