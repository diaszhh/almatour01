package kz.almatour1.repository;

import jakarta.transaction.Transactional;
import kz.almatour1.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {

}
