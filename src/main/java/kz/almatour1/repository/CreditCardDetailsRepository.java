package kz.almatour1.repository;

import jakarta.transaction.Transactional;
import kz.almatour1.model.City;
import kz.almatour1.model.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails, Long> {

}
