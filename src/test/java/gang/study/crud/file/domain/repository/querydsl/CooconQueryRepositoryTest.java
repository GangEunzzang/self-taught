package gang.study.crud.file.domain.repository.querydsl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CooconQueryRepositoryTest {

    @Autowired CooconQueryRepository queryRepository;

    @Test
    public void  검색_속도_테스트() throws Exception {
        //given
        queryRepository.exists("1391563044");
        //when

        //then

     }
}