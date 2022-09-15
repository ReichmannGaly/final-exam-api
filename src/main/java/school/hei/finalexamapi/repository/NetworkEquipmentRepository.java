package school.hei.finalexamapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.finalexamapi.model.NetworkEquipment;

@Repository
public interface NetworkEquipmentRepository extends JpaRepository<NetworkEquipment,Integer> {
}