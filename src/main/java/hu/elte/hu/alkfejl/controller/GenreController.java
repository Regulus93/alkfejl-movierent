package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Role({ADMIN,SUPERUSER})
    @PostMapping
    public ResponseEntity<Genre> addNewGenre(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping
    public ResponseEntity<Genre> removeGenre(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @GetMapping
    public ResponseEntity<Genre> getAllGenre(){
        return null;
    }

}
