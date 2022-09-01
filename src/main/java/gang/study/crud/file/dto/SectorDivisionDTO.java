package gang.study.crud.file.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SectorDivisionDTO {

    public Long id;

    public String largeSectorsCode;

    public String largeSectorsName;

    public String mediumSectorsCode;

    public String mediumSectorsName;

    public String update_date;

    public String provider;
}
