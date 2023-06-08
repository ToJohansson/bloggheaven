package tobiasjohansson.bloggheaven.boostrapData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tobiasjohansson.bloggheaven.model.Address;
import tobiasjohansson.bloggheaven.model.Post;
import tobiasjohansson.bloggheaven.model.User;
import tobiasjohansson.bloggheaven.repository.AddressRepository;
import tobiasjohansson.bloggheaven.repository.PostRepository;
import tobiasjohansson.bloggheaven.repository.UserRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        // ADDRESSES
        Address address1 = new Address("first street", "12323", "first city", "first country");
        Address address2 = new Address("second street", "45663", "second city", "second country");
        Address address3 = new Address("third street", "76762", "third city", "third country");
        Address address4 = new Address("forth street", "34344", "forth city", "forth country");
        Address address5 = new Address("fifth street", "89897", "fifth city", "fifth country");

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
        addressRepository.save(address4);
        addressRepository.save(address5);
        // USERS
        User user1 = new User("Ted","Mosby","mosbyTheArchitect@hotmail.com","84560093","standard",address1);
        User user2 = new User("Barney","Stinson","MrBroCode@outlook.com","002383838","premium",address2);
        User user3 = new User("Robin","Scherbatsky","canadaInterviewer@Gmail.com","234256553","enhanced",address3);
        User user4 = new User("Lily","Aldrin","info@kindergarden.net","75645345","premium",address4);
        User user5 = new User("Marshall","Eriksen","goVikings@ruralweb.net","23456654","standard",address4);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        // POST
        Post post1 = new Post("Slap Bet"," The origin of the slap bet can be found here in Season Two when the gang wonders why Robin does not want to go with them to a nearby shopping mall. Marshall and Barney have their theories and make a bet where the one who guesses the correct reason gets to slap the other.");
        Post post2 = new Post("The Bracket","An unidentified woman is sabotaging Barney's attempt to pick up girls by spreading the word that he uses them and should not be trusted. So, Barney and the gang come up with a list of 64 women who have reason to hate him and try to determine the culprit's identity through a bracket-style process of elimination.");
        Post post3 = new Post("Sandcastles in the Sand","Artsy ballad and features Robin's former teen boyfriend");
        Post post4 = new Post("Come On","Through various means, like a band playing blue instruments and a rather goofy rain dance, Ted finally lands Robin as a girlfriend after an exhaustive pursuit.");
        Post post5 = new Post("Ten Sessions","Dr. Stella Zinman (Sarah Chalke). Ted meets her and grows an attraction while getting his tattoo removed. Though she can't date him until after their 10 sessions are finished, Stella continues to say she still won't agree to a date.");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
    }
}
