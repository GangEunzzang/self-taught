package gang.study.crud.file.dto;

import gang.study.crud.file.domain.entity.ImportantData;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    /**
     * @param rs - ResultSet > 조회한 결과들을 저장
     * @return 조회한 결과를 DTO로 변환 (Coocon 전용)
     * @throws SQLException
     */
    public static ImportantDataDTO CooconDataRefine(ResultSet rs) throws SQLException {
        ImportantDataDTO coocon = ImportantDataDTO.builder()
                .companyRegisterNum(rs.getString("company_register_num"))
                .franchiseeName(rs.getString("franchisee_name"))
                .franchiseeAddress(rs.getString("franchisee_address"))
                .largeSectorsCode(rs.getString("large_sectors_code"))
                .largeSectorsName(rs.getString("large_sectors_name"))
                .postalCode("postal_code")
                .updateDate("update_date")
                .provider("Coocon")
                .priority("1")
                .build();
        return coocon;
    }


}
