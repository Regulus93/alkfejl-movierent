package hu.elte.hu.alkfejl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    @Id
    private Long id;

    private String director;

    private String title;

    private int year;

    private String status;

    private String senderUser;
}
