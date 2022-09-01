package gang.study.crud.file.domain.repository;

import gang.study.crud.file.domain.entity.BasicCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasicCategoryRepositoryTest {

    @Autowired
    BasicCategoryRepository basicCategoryRepository;

    @Test
    public void 기본카테고리_더미데이터() throws Exception {
        //given
        IntStream.rangeClosed(1, 30).forEach(i -> {
            BasicCategory category = BasicCategory.builder()
                    .categoryName("카테고리 이름" + i)
                    .categoryCode("Acha" + i)
                    .categoryDesc("카테고리 설명" + i)
                    .categoryOrder("순서" + i)
                    .build();
            basicCategoryRepository.save(category);
        });
        //when

        //then

    }
}