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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Actor extends BaseEntity{

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Movie> movies;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthday;

}
