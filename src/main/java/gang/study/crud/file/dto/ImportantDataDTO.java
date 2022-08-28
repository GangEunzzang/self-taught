package gang.study.crud.file.dto;

import gang.study.crud.file.domain.entity.ImportantData;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ImportantDataDTO {

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

    public static ImportantData toEntity(ImportantDataDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ImportantData importantData = modelMapper.map(dto, ImportantData.class);
        return importantData;
    }

    public static ImportantDataDTO toDTO(ImportantData entity) {
        ModelMapper modelMapper = new ModelMapper();
        ImportantDataDTO importantData = modelMapper.map(entity, ImportantDataDTO.class);
        return importantData;
    }
}
