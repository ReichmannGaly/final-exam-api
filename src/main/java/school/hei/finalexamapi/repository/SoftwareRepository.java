package school.hei.finalexamapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.finalexamapi.model.Software;

@Repository
public interface SoftwareRepository extends JpaRepository<Software,Integer> {
}
