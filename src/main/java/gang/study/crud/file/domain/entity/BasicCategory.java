package gang.study.crud.file.domain.entity;


import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class BasicCategory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basic_category_id")
    public Long id;

    public String categoryCode;

    public String categoryName;

    public String categoryOrder;

    public String categoryDesc;


}
