package school.hei.finalexamapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.finalexamapi.model.User;
import school.hei.finalexamapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(Integer id,User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User u = userOptional.get();
            u.setId(user.getId());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            return userRepository.save(u);
        }
        else {
            throw new NullPointerException("User not found");
        }
    }
}
