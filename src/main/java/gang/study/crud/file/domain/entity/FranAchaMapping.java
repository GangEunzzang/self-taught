package gang.study.crud.file.domain.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class FranAchaMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fran_acha_mapping_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_division_id")
    public SectorDivision sectorDivision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basic_category_id")
    public BasicCategory basicCategory;
}
