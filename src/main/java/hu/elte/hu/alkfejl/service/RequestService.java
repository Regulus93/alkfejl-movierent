package hu.elte.hu.alkfejl.service;

import hu.elte.hu.alkfejl.dto.RequestDTO;
import hu.elte.hu.alkfejl.entity.Request;
import hu.elte.hu.alkfejl.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public RequestDTO askMovie(Request request){
        requestRepository.save(request);

        RequestDTO requestResponse = new RequestDTO();
        requestResponse.setDirector(request.getDirector());
        requestResponse.setTitle(request.getTitle());
        requestResponse.setYear(request.getYear());
        return requestResponse;
    }

}
