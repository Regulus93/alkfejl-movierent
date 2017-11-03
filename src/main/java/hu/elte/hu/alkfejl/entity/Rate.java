package hu.elte.hu.alkfejl.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private Movie movie;

    @Column(nullable = false)
    @Lob
    private String opinion;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private User ratedUser;
}
