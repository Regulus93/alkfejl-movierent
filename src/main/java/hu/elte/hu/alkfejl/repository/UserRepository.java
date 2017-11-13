package hu.elte.hu.alkfejl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import hu.elte.hu.alkfejl.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        CrudRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username,
                                             String password);
}