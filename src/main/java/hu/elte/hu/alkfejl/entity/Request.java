package hu.elte.hu.alkfejl.entity;

import hu.elte.hu.alkfejl.enumtypes.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(columnDefinition = "VARCHAR(255) default 'UNCOMPLETED'")
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
