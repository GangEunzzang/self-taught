package gang.study.crud.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CooconRedisRepositoryTest {
    @Autowired CooconRedisRepository cooconRedisRepository;

    @Test
    public void 테스트() throws Exception {
        //given
        CooconRedis cooconRedis = new CooconRedis("1","Num","Name","largeCode","largeName","medium","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa","sdfa");
        //when
        cooconRedisRepository.save(cooconRedis);

        //then
     }
     
     @Test
     public void 검색_테스트 () throws Exception {
         //given
         Optional<CooconRedis> byId = cooconRedisRepository.findById("1");
         //when
         System.out.println(byId.getClass().getName());
         //then
         
      }
}