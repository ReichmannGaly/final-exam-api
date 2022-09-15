package school.hei.finalexamapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.finalexamapi.model.Software;
import school.hei.finalexamapi.repository.SoftwareRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SoftwareService {
    private SoftwareRepository softwareRepository;

    public List<Software> getAll(){
        return softwareRepository.findAll();
    }

    public Optional<Software> getById(Integer id){
        return softwareRepository.findById(id);
    }

    public Software save(Software software){
        return softwareRepository.save(software);
    }

    public Software update(Integer id,Software software){
        Optional<Software> softwareOptional = softwareRepository.findById(id);
        if(softwareOptional.isPresent()){
            Software s = softwareOptional.get();
            s.setId(software.getId());
            s.setName(software.getName());
            s.setSupplier(software.getSupplier());
            s.setEndOfLicence(software.getEndOfLicence());
            return softwareRepository.save(s);
        }
        else{
            throw new NullPointerException("Software not found");
        }
    }
}
