package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;
import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Role({USER,ADMIN,SUPERUSER})
    @GetMapping("/getAllMovie")
    public ResponseEntity<Movie> getAllMovie(){
        return null;
    }

    @Role({USER,ADMIN,SUPERUSER})
    @GetMapping("/getMovieDetails")
    public ResponseEntity<Movie> getMovieDetails(){
        return null;
    }

    @Role({USER,ADMIN,SUPERUSER})
    @GetMapping("/searchMovies")
    public ResponseEntity<Movie> searchMovies(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/archiveMovie")
    public ResponseEntity<Movie> archiveMovie(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/editMovie")
    public ResponseEntity<Movie> editMovie(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(){
        return null;
    }

}
