package school.hei.finalexamapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.finalexamapi.model.NetworkEquipment;
import school.hei.finalexamapi.repository.NetworkEquipmentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NetworkEquipmentService {
    private NetworkEquipmentRepository networkEquipmentRepository;

    public List<NetworkEquipment> getAll(){
        return networkEquipmentRepository.findAll();
    }

    public Optional<NetworkEquipment> getById(Integer id){
        return networkEquipmentRepository.findById(id);
    }


    public NetworkEquipment save(NetworkEquipment networkEquipment){
        return networkEquipmentRepository.save(networkEquipment);
    }

    public NetworkEquipment update(Integer id,NetworkEquipment networkEquipment) {
        Optional<NetworkEquipment> networkEquipmentOptional = networkEquipmentRepository.findById(id);
        if (networkEquipmentOptional.isPresent()) {
            NetworkEquipment n = networkEquipmentOptional.get();
            n.setId(networkEquipment.getId());
            n.setDeviceType(networkEquipment.getDeviceType());
            n.setBrand(networkEquipment.getBrand());
            n.setModel(networkEquipment.getModel());
            n.setIpAddress(networkEquipment.getIpAddress());
            n.setActive(networkEquipment.isActive());
            return networkEquipmentRepository.save(n);
        }
        else {
            throw new NullPointerException("Network equipment not found");
        }
    }
}
