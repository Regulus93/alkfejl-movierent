package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(name="passw"
            ,nullable = false)
    @Transient
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER, ADMINISTRATOR, SUPERUSER
    }

    @OneToMany(mappedBy = "senderUser")
    private List<Request> requests;

    @OneToMany(mappedBy = "rater")
    private List<Request> ratings;

    @OneToMany(mappedBy = "loaner")
    private List<Request> loans;
}
