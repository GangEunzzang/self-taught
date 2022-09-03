package gang.study.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Entity
public class CrudReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @Column(nullable = false, length = 250)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Crud crud;

    public void setCrud(Crud crud) {
        this.crud = crud;
    }


}
