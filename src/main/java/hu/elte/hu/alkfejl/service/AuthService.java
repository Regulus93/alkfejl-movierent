package hu.elte.hu.alkfejl.service;


import hu.elte.hu.alkfejl.dto.UserDTO;
import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.exception.InvalidLoginException;
import hu.elte.hu.alkfejl.repository.UserRepository;
import hu.elte.hu.alkfejl.util.DTO;
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

    public User register(@DTO(UserDTO.class) User user){
        userRepository.save(user);
        return user;
    }

    public UserDTO login(User user) throws InvalidLoginException {
        if(isValid(user)){
            currentUser = userRepository.findByUsername(user.getUsername()).get();
            UserDTO responseDTO = new UserDTO();
            responseDTO.setUsername(currentUser.getUsername());
            responseDTO.setId(currentUser.getId());
            return responseDTO;
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

