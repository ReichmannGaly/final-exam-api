package school.hei.finalexamapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.finalexamapi.model.Peripheral;

@Repository
public interface PeripheralRepository extends JpaRepository<Peripheral,Integer> {
}
