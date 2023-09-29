package dio.aulaspringdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.aulaspringdatajpa.model.User;
import dio.aulaspringdatajpa.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Arilson");
        user.setUsername("arilson");
        user.setPassword("123456");
        userRepository.save(user);

        for (User u : userRepository.findAll()) {
            System.out.println(u);
        }
    }

}


NIVERLINUXTIPS
