package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(nullable = false)
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;


}