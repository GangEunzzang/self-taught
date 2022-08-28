package gang.study.crud.file.dto;

import gang.study.crud.file.domain.entity.CooconData;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CooconDataDTO {

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
     *  '대분류 업종코드'
     */
    private String largeSectorsCode;

    /**
     *  '대분류 업종명'
     */
    private String largeSectorsName;

    /**
     *   '중분류 업종코드'
     */
    private String mediumSectorsCode;

    /**
     *   '증분류 업종명'
     */
    private String mediumSectorsName;

    /**
     *   '소분류 업종코드'
     */
    private String smallSectorsCode;

    /**
     *   '소분류 업종명'
     */
    private String smallSectorsName;

    /**
     *   '가맹점 주소'
     */
    private String franchiseeAddress;

    /**
     *   '우편 번호'
     */
    private String postalCode;

    /**
     *   '갱신 일자'
     */
    private String updateDate;

    /**
     *   '가맹점정보 상태 구분값'
     */
    private String franchiseeInfoStatus;

    /**
     *   '휴폐업 구분'
     */
    private String franchiseeInfoDivision;

    /**
     *   '폐업 일자'
     */
    private String closeDate;

    /**
     *   '휴폐업 변경 여부'
     */
    private String franchiseeInfoStatusChange;

    /**
     *   '하위 가맹점 건수'
     */
    private String subFranchiseNum;


    public static CooconData toEntity(CooconDataDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        CooconData cooconData = modelMapper.map(dto, CooconData.class);
        return cooconData;
    }

    public static CooconDataDTO toDTO(CooconData entity) {
        ModelMapper modelMapper = new ModelMapper();
        CooconDataDTO cooconDataDTO = modelMapper.map(entity, CooconDataDTO.class);
        return cooconDataDTO;
    }
}
