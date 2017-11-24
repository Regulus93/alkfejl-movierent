package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;
import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @Role({USER,ADMIN,SUPERUSER})
    @PostMapping("/extend")
    public ResponseEntity<Loan> extendLoan(){
        return null;
    }

    @Role({ADMIN,SUPERUSER})
    @PostMapping("/getAllLoan")
    public ResponseEntity<Loan> getAllLoan(){
        return null;
    }

    @Role({USER,ADMIN,SUPERUSER})
    @GetMapping("/loanMovie")
    public ResponseEntity<Loan> loanMovie(){
        return null;
    }

}
