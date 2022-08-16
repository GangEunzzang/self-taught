package gang.study.crud.dto;

import com.querydsl.core.annotations.QueryProjection;
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

    @QueryProjection
    public CrudDTO(Long bno, String title, String content) {
        this.bno = bno;
        this.title = title;
        this.content = content;
    }


}
