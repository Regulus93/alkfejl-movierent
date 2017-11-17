package hu.elte.hu.alkfejl.service;

import hu.elte.hu.alkfejl.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
