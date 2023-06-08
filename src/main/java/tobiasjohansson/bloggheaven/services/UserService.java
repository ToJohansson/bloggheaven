package tobiasjohansson.bloggheaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobiasjohansson.bloggheaven.exceptions.ResourceNotFoundException;
import tobiasjohansson.bloggheaven.model.User;
import tobiasjohansson.bloggheaven.repository.UserRepository;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User userById(long id)throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "ID", id));
        return user;
    }

    public User saveUser(User user) {
        addressService.addAddress(user.getAddress());
        return userRepository.save(user);
    }

}
