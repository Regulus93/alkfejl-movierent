package hu.elte.hu.alkfejl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    @Id
    private Long id;

    @NotNull
    private String director;

    @NotNull
    private String title;

    @NotNull
    private int year;

    private String status;

    private String senderUser;
}
