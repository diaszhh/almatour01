package kz.almatour1.repository;

import jakarta.transaction.Transactional;
import kz.almatour1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
