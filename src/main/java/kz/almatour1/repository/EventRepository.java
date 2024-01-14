package kz.almatour1.repository;

import jakarta.transaction.Transactional;
import kz.almatour1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {

}
