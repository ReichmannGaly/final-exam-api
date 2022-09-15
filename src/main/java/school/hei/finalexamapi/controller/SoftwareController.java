package school.hei.finalexamapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.finalexamapi.model.Software;
import school.hei.finalexamapi.service.SoftwareService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class SoftwareController {
    private SoftwareService softwareService;

    @GetMapping("/softwares")
    public List<Software> getSoftwares(){
        return softwareService.getAll();
    }

    @GetMapping("/softwares/{id}")
    public Optional<Software> getSoftwareById(@PathVariable Integer id){
        return softwareService.getById(id);
    }

    @PostMapping("/softwares")
    public Software createSoftware(@RequestBody Software software){
        return softwareService.save(software);
    }

    @PutMapping("/softwares/{id}")
    public Software updateSoftware(@PathVariable Integer id, @RequestBody Software software) {
        return softwareService.update(id, software);
    }
}
