package gang.study.crud.querydsl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrudSearchCondition {
    private String title;
    private String content;
}
