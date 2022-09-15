package school.hei.finalexamapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.finalexamapi.model.Peripheral;
import school.hei.finalexamapi.repository.PeripheralRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeripheralService {
    private PeripheralRepository peripheralRepository;

    public List<Peripheral> getAll(){
        return peripheralRepository.findAll();
    }

    public Optional<Peripheral> getById(Integer id){
        return peripheralRepository.findById(id);
    }

    public Peripheral save(Peripheral peripheral){
        return peripheralRepository.save(peripheral);
    }

    public Peripheral update(Integer id,Peripheral peripheral){
        Optional<Peripheral> peripheralOptional = peripheralRepository.findById(id);
        if(peripheralOptional.isPresent()){
            Peripheral p = peripheralOptional.get();
            p.setId(peripheral.getId());
            p.setBrand(peripheral.getBrand());
            p.setModel(peripheral.getModel());
            p.setOperational(peripheral.isOperational());
            return peripheralRepository.save(p);
        }
        else {
            throw new NullPointerException("Peripheral device not found");
        }
    }
}
