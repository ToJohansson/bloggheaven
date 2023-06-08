package tobiasjohansson.bloggheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> userById(@PathVariable("id")long id){
        return new ResponseEntity<User>(userService.userById(id),HttpStatus.OK);
    }
    @PostMapping("/newuser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
