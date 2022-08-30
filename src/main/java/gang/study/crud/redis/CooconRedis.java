package gang.study.crud.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "test", timeToLive = 50)
@Getter
@AllArgsConstructor
@Builder
public class CooconRedis {
    @Id
    private String id;


    /**
     *   '사업자 등록번호'
     */
    @Indexed // 필드 값으로 데이터 찾을 수 있게 하는 어노테이션(findByAccessToken)
    private String companyRegisterNum;

    /**
     *   '가맹점명'
     */
    private String franchiseeName;

    /**
     *   '대분류 업종코드'
     */
    private String largeSectorsCode;

    /**
     *   '대분류 업종명'
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

}
