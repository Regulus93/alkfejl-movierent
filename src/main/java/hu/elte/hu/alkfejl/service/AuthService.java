package hu.elte.hu.alkfejl.service;


import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.exception.InvalidLoginException;
import hu.elte.hu.alkfejl.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;
import static hu.elte.hu.alkfejl.enumtype.UserStatus.ACTIVE;

@Service
@SessionScope
@Data
public class AuthService {

    private User currentUser;

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        user.setRole(USER);
        user.setStatus(ACTIVE);
        currentUser = userRepository.save(user);
        return user;
    }

    public User login(User user) throws InvalidLoginException {
        if(isValid(user)){
            return user;
        } else {
            throw new InvalidLoginException();
        }
    }

    private boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}

