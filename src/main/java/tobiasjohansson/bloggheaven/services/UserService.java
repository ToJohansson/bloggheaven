package tobiasjohansson.bloggheaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobiasjohansson.bloggheaven.model.User;
import tobiasjohansson.bloggheaven.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User userById(long id) {
        Optional<User> opUser = userRepository.findById(id);
        if (opUser.isPresent()) {
            return opUser.get();
        } else
            return null;
    }

    public User saveUser(User user) {

        long userId = user.getUserId();
        if (!userRepository.existsById(userId)) {
            user.setAdress(addressService.addAddress(user.getAdress()));
            userRepository.save(user);
            return user;
        }
        return null;
    }

}
