package school.hei.finalexamapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.finalexamapi.model.Computer;
import school.hei.finalexamapi.repository.ComputerRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComputerService {
    private school.hei.finalexamapi.repository.ComputerRepository computerRepository;

    public List<Computer> getAll(){
        return computerRepository.findAll();
    }

    public Optional<Computer> getById(Integer id){
        return computerRepository.findById(id);
    }

    public Computer save(Computer computer){
        return computerRepository.save(computer);
    }

    public Computer update(Integer id,Computer computer){
        Optional<Computer> computerOptional = computerRepository.findById(id);
        if(computerOptional.isPresent()){
            Computer c = computerOptional.get();
            c.setId(computer.getId());
            c.setBrand(computer.getBrand());
            c.setModel(computer.getModel());
            c.setCpu(computer.getCpu());
            c.setRamCapacity(computer.getRamCapacity());
            c.setOperatingSystem(computer.getOperatingSystem());
            c.setIpAddress(computer.getIpAddress());
            c.setPrincipalUser(computer.getPrincipalUser());
            c.setOperational(computer.isOperational());
            return computerRepository.save(c);
        }
        else {
            throw new NullPointerException("Computer not found");
        }
    }
}
