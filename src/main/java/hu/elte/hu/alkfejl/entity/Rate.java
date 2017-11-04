package hu.elte.hu.alkfejl.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rate extends BaseEntity{

    @Column(nullable = false)
    private Date rateAdded;

    @Column(nullable = false)
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;

    @Column(nullable = false)
    @Lob
    private String opinion;

    @Column(nullable = false)
    private int pointValue;

    @Column(nullable = false)
    @JoinColumn(name="USER_ID")
    private User rater;
}
