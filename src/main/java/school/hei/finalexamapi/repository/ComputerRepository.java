package school.hei.finalexamapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.finalexamapi.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer,Integer>  {
}
