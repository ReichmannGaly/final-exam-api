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
import school.hei.finalexamapi.model.Peripheral;
import school.hei.finalexamapi.service.PeripheralService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class PeripheralController {
    private PeripheralService peripheralService;

    @GetMapping("/peripherals")
    public List<Peripheral> getPeripherals(){
        return peripheralService.getAll();
    }

    @GetMapping("/periherals/{id}")
    public Optional<Peripheral> getPeripheralById(@PathVariable Integer id){
        return peripheralService.getById(id);
    }

    @PostMapping("/peripherals")
    public Peripheral createComputer(@RequestBody Peripheral peripheral){
        return peripheralService.save(peripheral);
    }

    @PutMapping("/peripherals/{id}")
    public Peripheral updatePeripheral(@PathVariable Integer id, @RequestBody Peripheral peripheral){
        return peripheralService.update(id,peripheral);
    }
}
