package hu.elte.hu.alkfejl.entity;

import hu.elte.hu.alkfejl.enumtype.UserRole;
import hu.elte.hu.alkfejl.enumtype.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(columnDefinition = "VARCHAR(255) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(name="passw"
            ,nullable = false)
//    @Transient
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(nullable = false)
    @OneToMany(mappedBy = "senderUser")
    private List<Request> requests;

    @Column(nullable = false)
    @OneToMany(mappedBy = "rater")
    private List<Rate> ratings;

    @Column(nullable = false)
    @OneToMany(mappedBy = "loaner")
    private List<Loan> loans;

    @Override
    public String toString() {
        return "User[id=" + super.getId()
                + ", username=" + username
                + ", name=" + name
                + ", role=" + role
                + "]";
    }
}
