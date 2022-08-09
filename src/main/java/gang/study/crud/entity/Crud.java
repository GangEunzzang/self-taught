package gang.study.crud.entity;

import lombok.*;
import org.mapstruct.Mapper;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Mapper
public class Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bno;

    @Column(length = 50, nullable = false)
    public String title;

    @Column(length = 1000, nullable = false)
    public String content;


}
