package gang.study.crud.redis;

import gang.study.crud.file.domain.entity.CooconData;
import gang.study.crud.file.domain.repository.CooconDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTests {

    @Autowired
    CooconDataRepository cooconDataRepository;

    @Test
    void test() {
        cooconDataRepository.save(CooconData.builder().companyRegisterNum("12342143").build());
    }
}

