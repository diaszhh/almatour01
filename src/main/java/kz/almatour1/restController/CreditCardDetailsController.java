package kz.almatour1.restController;

import kz.almatour1.dto.CreditCardDetailsDTO;
import kz.almatour1.service.CreditCardDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//sdfasdf
@RequiredArgsConstructor
@RequestMapping(value = "/credit-card-details")
public class CreditCardDetailsController {

    private final CreditCardDetailsService creditCardDetailsService;

    @GetMapping
    public List<CreditCardDetailsDTO> getCreditCardDetails() {
        return creditCardDetailsService.creditCardDetails();
    }

    @GetMapping(value = "/{id}")
    public CreditCardDetailsDTO getCreditCardDetailsById(@PathVariable Long id) {
        return creditCardDetailsService.creditCardDetailsById(id);
    }


    @PostMapping
    public CreditCardDetailsDTO addCreditCardDetailsById(@RequestBody CreditCardDetailsDTO creditCardDetailsDTO) {
        return creditCardDetailsService.addCreditCardDetails(creditCardDetailsDTO.getUserId(), creditCardDetailsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCreditCardDetailsById(@PathVariable Long id) {
        creditCardDetailsService.deleteCreditCardDetailsById(id);
    }
}
