package hu.elte.hu.alkfejl.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rate extends BaseEntity{

    @Column(nullable = false)
    private Date rateAdded;

    @JoinColumn(name="MOVIE_ID")
    @ManyToOne
    private Movie ratedMovie;

    @Column(nullable = false)
    @Lob
    private String opinion;

    @Column(nullable = false)
    private int pointValue;

    @JoinColumn(name="USER_ID")
    @ManyToOne
    private User rater;
}
