package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    @JoinColumn(name = "GENRE_ID")
    @ManyToOne
    private Genre genre;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @Column(nullable = false)
    @OneToMany(mappedBy = "loanedMovie")
    private List<Loan> loans;

    @Column(nullable = false)
    @OneToMany(mappedBy = "ratedMovie")
    private List<Rate> rates;


}