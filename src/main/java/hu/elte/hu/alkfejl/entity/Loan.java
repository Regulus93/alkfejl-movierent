package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Loan extends BaseEntity{

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User loaner;

    @JoinColumn(name = "MOVIE_ID")
    @ManyToOne
    private Movie loanedMovie;

    @Column(nullable = false)
    private Date loanStart;

    @Column(nullable = false)
    private Date loanEnd;

}
