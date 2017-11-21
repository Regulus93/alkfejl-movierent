package hu.elte.hu.alkfejl.controller;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.dto.RequestDTO;
import hu.elte.hu.alkfejl.entity.Request;
import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.repository.RequestRepository;
import hu.elte.hu.alkfejl.service.AuthService;
import hu.elte.hu.alkfejl.service.RequestService;
import hu.elte.hu.alkfejl.service.UserService;
import hu.elte.hu.alkfejl.util.DTO;
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

    @Autowired
    private AuthService authService;

    @Autowired
    private RequestService requestService;

//    EndPoint name: askMovie
//    Role: USER, ADMINISTRATOR, SUPERUSER
//    Logic simple description: add new row to the requests table

    //TODO: Connect with session user
    @Role({USER,ADMIN,SUPERUSER})
    @PostMapping("/askMovie")
    public ResponseEntity<RequestDTO> askMovie(@DTO(RequestDTO.class) Request request) {
        request.setSenderUser(authService.getCurrentUser());
        RequestDTO responseDTO = requestService.askMovie(requestRepository.save(request));
        return ResponseEntity.ok(responseDTO);
    }

//    EndPoint name: requestCompleted
//    Role: ADMINISTRATOR, SUPERUSER
//    Logic simple description: add new row to the requests table
    @Role({ADMIN,SUPERUSER})
    @PostMapping("/requestCompleted")
    public ResponseEntity<RequestDTO> requestCompleted(@DTO(RequestDTO.class) Request request) {
        return ResponseEntity.ok(requestService.makeRequestCompleted(request));
    }
}
