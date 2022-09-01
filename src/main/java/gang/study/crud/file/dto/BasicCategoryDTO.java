package gang.study.crud.file.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BasicCategoryDTO {
    public Long id;

    public String categoryCode;

    public String categoryName;

    public String categoryOrder;

    public String categoryDesc;
}
