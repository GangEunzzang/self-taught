package gang.study.crud.file.domain.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class SectorDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String largeSectorsCode;

    public String largeSectorsName;

    public String mediumSectorsCode;

    public String mediumSectorsName;

    public String update_date;

    public String provider;

}
