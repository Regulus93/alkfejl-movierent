package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.entity.Request;
import hu.elte.hu.alkfejl.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static hu.elte.hu.alkfejl.enumtype.UserRole.ADMIN;
import static hu.elte.hu.alkfejl.enumtype.UserRole.SUPERUSER;
import static hu.elte.hu.alkfejl.enumtype.UserRole.USER;

@RestController
@RequestMapping("/request/")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

//    EndPoint name: askMovie
//    Role: USER, ADMINISTRATOR, SUPERUSER
//    Logic simple description: add new row to the requests table

    //TODO: Connect with session user
    @Role({USER,ADMIN,SUPERUSER})
    @PostMapping("/askMovie")
    public ResponseEntity<Request> askMovie(@RequestBody Request request) {
        requestRepository.save(request);
        return ResponseEntity.ok(request);
    }


//    EndPoint name: requestCompleted
//    Role: ADMINISTRATOR, SUPERUSER
//    Logic simple description: add new row to the requests table
}
