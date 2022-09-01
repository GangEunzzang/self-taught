package gang.study.crud.file.dto;

import gang.study.crud.file.domain.entity.CooconData;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    public static List<CooconDataDTO> readDataToDTO(List<String> fileTotalReadLine) {

        List<CooconDataDTO> cooconDataDTOList = new ArrayList<>();

        IntStream.range(0, fileTotalReadLine.size()).forEachOrdered(i -> {
            String[] conversionData = fileTotalReadLine.get(i).split("\\|"); //파이프라인 제거
            CooconDataDTO cooconDataDTO = CooconDataDTO.builder()
                    .companyRegisterNum(conversionData[1]).franchiseeName(conversionData[2])
                    .largeSectorsCode(conversionData[3]).largeSectorsName(conversionData[4])
                    .mediumSectorsCode(conversionData[5]).mediumSectorsName(conversionData[6])
                    .smallSectorsCode(conversionData[7]).smallSectorsName(conversionData[8])
                    .franchiseeAddress(conversionData[9]).postalCode(conversionData[10])
                    .updateDate(conversionData[11]).franchiseeInfoStatus(conversionData[12])
                    .franchiseeInfoDivision(conversionData[13]).closeDate(conversionData[14])
                    .build();
            cooconDataDTOList.add(cooconDataDTO);
            System.out.println("리스트 분리 : " + cooconDataDTOList.get(i));
        });
        return cooconDataDTOList;
    }
}
