package gang.study.crud.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class JavaTests {

    @BeforeEach
    public void test() {

    }
    @Test
    public void 테스트_스트림 () throws Exception {
        //given
        String aa = "D|1790302310|행운모텔|H18|여행|D001|숙박|D001006|모텔|부산광역시 영도구 남항서로 126|49045|20220811|간이미발급||0";

        String [] split = aa.split("\\|");
        IntStream.rangeClosed(1, split.length).forEach(System.out::println);


        //when

        //then

     }
}
