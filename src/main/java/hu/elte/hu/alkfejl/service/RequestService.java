package hu.elte.hu.alkfejl.service;

import hu.elte.hu.alkfejl.dto.RequestDTO;
import hu.elte.hu.alkfejl.entity.Request;
import hu.elte.hu.alkfejl.enumtype.RequestStatus;
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

    public RequestDTO makeRequestCompleted(Request request){
        Request persistedRequest = requestRepository.findOne(request.getId());
        if(RequestStatus.UNCOMPLETED == persistedRequest.getStatus()){
            persistedRequest.setStatus(RequestStatus.COMPLETED);
            requestRepository.save(persistedRequest);
            //TODO: Insert completed movie to the database
        }

        return createRequestResponse(persistedRequest);
    }

    private RequestDTO createRequestResponse(Request persistedRequest){
        RequestDTO requestResponse = new RequestDTO();
        requestResponse.setStatus(persistedRequest.getStatus().toString());
        requestResponse.setDirector(persistedRequest.getDirector());
        requestResponse.setTitle(persistedRequest.getTitle());
        requestResponse.setYear(persistedRequest.getYear());
        return requestResponse;
    }
}
