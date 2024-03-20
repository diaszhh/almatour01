package kz.almatour1.service;

import kz.almatour1.dto.CreditCardDetailsDTO;
import kz.almatour1.mapper.CreditCardDetailsMapper;
import kz.almatour1.model.CreditCardDetails;
import kz.almatour1.model.User;
import kz.almatour1.repository.CreditCardDetailsRepository;
import kz.almatour1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardDetailsService {
    private final CreditCardDetailsRepository creditCardDetailsRepository;
    private final CreditCardDetailsMapper creditCardDetailsMapper;
    private final UserRepository userRepository;

    public List<CreditCardDetailsDTO> creditCardDetails() {
        return creditCardDetailsMapper.toDTOList(creditCardDetailsRepository.findAll());
    }

    public CreditCardDetailsDTO creditCardDetailsById(Long id) {
        return creditCardDetailsMapper.toDTO(creditCardDetailsRepository.findById(id).orElse(null));
    }

    public void deleteCreditCardDetailsById(Long id) {
        creditCardDetailsRepository.deleteById(id);
    }

    @SneakyThrows
    public CreditCardDetailsDTO addCreditCardDetails(Long id, CreditCardDetailsDTO creditCardDetailsDTO) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException("User not found with id: " + id));

        CreditCardDetails creditCardDetails = new CreditCardDetails();
        creditCardDetailsRepository.save(creditCardDetailsMapper.toEntity(creditCardDetailsDTO));
        creditCardDetails.setUser(user);

        return creditCardDetailsMapper.toDTO(creditCardDetails);
    }
}
