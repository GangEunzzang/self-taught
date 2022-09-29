package gang.study.crud.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudDTO {
    private Long bno;
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "작성자 정보가 없습니다.")
    private String writer;

    private List<CrudReplyDTO> crudReplyDTOList = new ArrayList<>();

    @QueryProjection
    public CrudDTO(Long bno, String title, String content) {
        this.bno = bno;
        this.title = title;
        this.content = content;
    }


}
