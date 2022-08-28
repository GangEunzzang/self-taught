package gang.study.crud.file.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class ImportantData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * '사업자 등록번호'
     */
    private String companyRegisterNum;

    /**
     * '가맹점명'
     */
    private String franchiseeName;

    /**
     * '대분류 업종코드'
     */
    private String largeSectorsCode;

    /**
     * '대분류 업종명'
     */
    private String largeSectorsName;


    /**
     * '가맹점 주소'
     */
    private String franchiseeAddress;

    /**
     * '우편 번호'
     */
    private String postalCode;

    /**
     * '갱신 일자'
     */
    private String updateDate;

    /**
     * '제공 업체'
     */
    private String provider;

    /**
     * '우선 순위'
     */
    private String priority;
}
