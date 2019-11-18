package pl.mariuszg95.spring.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszg95.spring.data.model.User;
import pl.mariuszg95.spring.data.repositories.UserRepository;
import pl.mariuszg95.spring.dto.RegisterFormDTO;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public User getUser(String login) {
        return userRepository.getByLogin(login);
    }

    public boolean isLoginTaken(String login) {

        try {
            User user = userRepository.getByLogin(login);
            user.getLogin();
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    public void insertUser(RegisterFormDTO registerFormDTO) {

        User user = new User();
        user.setLogin(registerFormDTO.getLogin());
        user.setEmail(registerFormDTO.getEmail());
        user.setPassword(registerFormDTO.getPassword());
        user.setFirstName(registerFormDTO.getFirstName());
        user.setLastName(registerFormDTO.getLastName());
        user.setBirthDate(registerFormDTO.getBirthDate());
        user.setActive(true);


        userRepository.save(user);
        userRepository.setUserRole(user.getLogin());
    }
}
