package school.hei.finalexamapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.finalexamapi.model.Computer;
import school.hei.finalexamapi.service.ComputerService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class ComputerController {
    private ComputerService computerService;

    @GetMapping("/computers")
    public List<Computer> getComputers(){
        return computerService.getAll();
    }

    @GetMapping("/computers/{id}")
    public Optional<Computer> getComputerById(@PathVariable Integer id){
        return computerService.getById(id);
    }

    @PostMapping("/computers")
    public Computer createComputer(@RequestBody Computer computer){
        return computerService.save(computer);
    }

    @PutMapping("/computers/{id}")
    public Computer updateComputer(@PathVariable Integer id, @RequestBody Computer computer){
        return computerService.update(id,computer);
    }
}
