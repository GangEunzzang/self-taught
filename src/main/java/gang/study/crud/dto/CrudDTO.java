package gang.study.crud.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudDTO {
    private Long bno;
    private String title;
    private String content;

}
