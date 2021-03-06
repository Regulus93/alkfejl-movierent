package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.Rate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;
import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;

@Controller
@RequestMapping("/rate")
public class RateController {

    @Role({ADMIN,SUPERUSER})
    @GetMapping("/getAllRate")
    public ResponseEntity<Rate> getAllRate(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/archiveRate")
    public ResponseEntity<Rate> archiveRate(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/unarchiveRate")
    public ResponseEntity<Rate> unarchiveRate(){
        return null;
    }

    @Role({USER,ADMIN,SUPERUSER})
    @PostMapping("/rateMovie")
    public ResponseEntity<Rate> rateMovie(){
        return null;
    }

}
