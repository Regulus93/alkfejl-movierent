package hu.elte.hu.alkfejl.repository;

import hu.elte.hu.alkfejl.entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

}
