package tobiasjohansson.bloggheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tobiasjohansson.bloggheaven.model.User;
import tobiasjohansson.bloggheaven.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User userById(@PathVariable("id")long id){
        return userService.userById(id);
    }
    @PostMapping("/newuser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
