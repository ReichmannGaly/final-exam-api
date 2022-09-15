package school.hei.finalexamapi.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.finalexamapi.model.User;
import school.hei.finalexamapi.service.UserService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getComputerById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User createComputer(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateComputer(@PathVariable Integer id, @RequestBody User user){
        return userService.update(id,user);
    }
}
