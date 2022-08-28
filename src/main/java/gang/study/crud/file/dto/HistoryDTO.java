package gang.study.crud.file.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HistoryDTO {

    private long id;

    /**
     * 파일명
     */
    private String fileName;

    /**
     * 파일 생성 일자
     */
    private String fileGenTime;

    /**
     * 파일 크기
     */
    private String fileSize;

    /**
     * 작업 시작 시간
     */
    private String startTime;

    /**
     * 작업 소요 시간
     */
    private String workTime;

    /**
     * 작업 종료 사간
     */
    private String endTime;

    /**
     * 작업 성공 여부
     */
    private String success;

    /**
     * 작업 데이터 수
     */
    private String dataCount;

    /**
     * 실패 사유
     */
    private String failReason;
}
