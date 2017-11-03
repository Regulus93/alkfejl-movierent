package hu.elte.hu.alkfejl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Request extends BaseEntity {

    //user - many to one
    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User senderUser;

    //title
    @Column(nullable = false)
    private String title;

    //year
    @Column(nullable = false)
    private int year;

    //director
    @Column(nullable = false)
    private String director;

}
