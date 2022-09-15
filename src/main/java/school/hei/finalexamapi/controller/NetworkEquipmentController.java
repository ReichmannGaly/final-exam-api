package school.hei.finalexamapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.finalexamapi.model.NetworkEquipment;
import school.hei.finalexamapi.service.NetworkEquipmentService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class NetworkEquipmentController {
    private NetworkEquipmentService networkEquipmentService
            ;

    @GetMapping("/networkEquipments")
    public List<NetworkEquipment> getNetworkEquipments(){
        return networkEquipmentService.getAll();
    }

    @GetMapping("/networkEquipments/{id}")
    public Optional<NetworkEquipment> getNetworkEquipmentById(@PathVariable Integer id){
        return networkEquipmentService.getById(id);
    }

    @PostMapping("/networkEquipments")
    public NetworkEquipment createNetworkEquipment(@RequestBody NetworkEquipment networkEquipment){
        return networkEquipmentService.save(networkEquipment);
    }

    @PutMapping("/networkEquipments/{id}")
    public NetworkEquipment updateNetworkEquipment(@PathVariable Integer id, @RequestBody NetworkEquipment networkEquipment){
        return networkEquipmentService.update(id,networkEquipment);
    }
}
