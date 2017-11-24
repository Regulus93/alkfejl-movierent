package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.dto.UserDTO;
import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.exception.InvalidLoginException;
import hu.elte.hu.alkfejl.repository.UserRepository;
import hu.elte.hu.alkfejl.service.AuthService;
import hu.elte.hu.alkfejl.util.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register (@DTO(UserDTO.class) User user){
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> getLogin(@DTO(UserDTO.class) User user) {
        try {
            return ResponseEntity.ok(authService.login(user));
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        authService.setCurrentUser(null);
        return ResponseEntity.ok("You have been logged out successfully.");
    }
}