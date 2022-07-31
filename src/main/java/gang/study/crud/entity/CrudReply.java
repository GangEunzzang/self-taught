package gang.study.crud.entity;

import lombok.*;
import org.springframework.stereotype.Controller;

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
    private Crud crud;


}
