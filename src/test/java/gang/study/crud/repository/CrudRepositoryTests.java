package gang.study.crud.repository;

import gang.study.crud.entity.Crud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class CrudRepositoryTests {

    @Autowired CrudRepository crudRepository;

    @Test
    public void insert(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Crud crud = Crud.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .build();
            crudRepository.save(crud);
        });
    }

}
