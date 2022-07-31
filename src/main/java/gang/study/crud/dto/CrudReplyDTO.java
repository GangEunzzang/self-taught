package gang.study.crud.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrudReplyDTO {
    private Long rno;
    private String content;
    private Long crud;
}
