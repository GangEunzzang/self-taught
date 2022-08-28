package gang.study.crud.file.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
@Entity
public   class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private String fileGenTime;

    private String fileSize;

    private String startTime;

    private String workTime;

    private String endTime;

    private String success;

    private String dataCount;

    private String failReason;
}
