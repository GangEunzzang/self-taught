package gang.study.crud.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudDTO {
    private Long bno;
    private String title;
    private String content;
    private String writer;

    private List<CrudReplyDTO> crudReplyDTOList = new ArrayList<>();

}
