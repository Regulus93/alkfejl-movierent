package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;
import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;

@Controller
@RequestMapping("/user")
public class UserController {

    @Role({SUPERUSER})
    @GetMapping("/getAllUser")
    public ResponseEntity<User> getAllUser(){
        return null;
    }

    @Role({USER,ADMIN,SUPERUSER})
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(){
        return null;
    }

    @Role({SUPERUSER})
    @PostMapping("/makeUserActive")
    public ResponseEntity<User> makeUserActive(){
        return null;
    }

    @Role({SUPERUSER})
    @PostMapping("/makeUserInactive")
    public ResponseEntity<User> makeUserInactive(){
        return null;
    }

    @Role({SUPERUSER})
    @PostMapping("/modifyUserRole")
    public ResponseEntity<User> modifyUserRole(){
        return null;
    }

}
