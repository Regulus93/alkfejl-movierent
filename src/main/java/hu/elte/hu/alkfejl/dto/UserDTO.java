package hu.elte.hu.alkfejl.dto;

import hu.elte.hu.alkfejl.enumtype.UserRole;
import hu.elte.hu.alkfejl.enumtype.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    private Long id;

    private UserRole role;

    private UserStatus status;

    private String name;

    @NotNull
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String password;
}
