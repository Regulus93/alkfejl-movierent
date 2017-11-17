package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.exception.InvalidLoginException;
import hu.elte.hu.alkfejl.repository.UserRepository;
import hu.elte.hu.alkfejl.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody User user){
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> getLogin(@RequestBody User user) {
        try {
            return ResponseEntity.ok(authService.login(user));
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
//
//    @PostMapping("/login")
//    public String postLogin(
//            @ModelAttribute User loginUser) {
//        Optional<User> login =
//                userRepository.findByUsernameAndPassword(
//                        loginUser.getUsername(),
//                        loginUser.getPassword());
//        if(login.isPresent()) {
//            System.out.println("Login successful");
//            System.out.println(login.get().toString());
//            authService.setCurrentUser(login.get());
//        } else {
//            System.out.println("Login failed");
//        }
//        return "redirect:/auth/login";
//    }
//
//    @RequestMapping("/logout")
//    public String logout() {
//        authService.setCurrentUser(null);
//        return "redirect:/auth/login";
//    }
//
//    @RequestMapping("/debug")
//    public String debug() {
//        System.out.println(authService.getCurrentUser());
//        return "redirect:/auth/login";
//    }
}