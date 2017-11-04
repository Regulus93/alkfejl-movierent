package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Loan extends BaseEntity{

    //user
    @Column(nullable = false)
    @JoinColumn(name = "USER_ID")
    private User loaner;

    //movie
    @Column(nullable = false)
    @JoinColumn(name = "MOVIE_ID")
    private Movie loanedMovie;

    //loanStart
    @Column(nullable = false)
    private Date loanStart;

    //loanEnd
    @Column(nullable = false)
    private Date loanEnd;

}
