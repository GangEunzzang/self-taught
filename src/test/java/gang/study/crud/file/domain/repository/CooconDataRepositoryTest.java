package gang.study.crud.file.domain.repository;

import gang.study.crud.file.domain.entity.CooconData;
import gang.study.crud.file.dto.CooconDataDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CooconDataRepositoryTest {

    @Autowired
    CooconDataRepository repository;

    private JdbcTemplate jdbcTemplate;

    public void setDatSource(DataSource datSource) {
        this.jdbcTemplate = new JdbcTemplate(datSource);
    }

    StopWatch stopWatch = new StopWatch();


//    @Test
//    public void 데이터_1개_변환_출력_테스트 () throws Exception {
//        //given
//        Optional<CooconData> data = repository.findById(2L);
//        //when
//
//        CooconDataDTO toDTO = CooconDataDTO.toDTO(data);
//
//        //then
//        System.out.println(toDTO);
//     }

    @Test
    public void 대용량_데이터_가져오기_테스트 () throws Exception {
        stopWatch.start();
        //given
        List<CooconData> all = repository.findAll();

        List<CooconDataDTO> dataDTOList = new ArrayList<>();

        //when
        for (int i=0; i<all.size(); i++) {
            dataDTOList.add(CooconDataDTO.toDTO(all.get(i)));

            System.out.println(dataDTOList.get(i));
        }
        //then
        stopWatch.stop();

        System.out.println(stopWatch.getTime());
     }


     @Test
     public void JDBC_템플릿_테스트 () throws Exception {
         jdbcTemplate.execute("select * from crud");//given

         //when

         //then

      }


}