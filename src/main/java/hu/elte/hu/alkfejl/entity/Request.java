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

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @JoinColumn(name="USER_ID")
    @ManyToOne
    private User senderUser;
}
