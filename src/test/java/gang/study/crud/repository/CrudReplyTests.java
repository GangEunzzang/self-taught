package gang.study.crud.repository;

import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class CrudReplyTests {

    @Autowired
    CrudReplyRepository crudReplyRepository;


    @Test
    public void insertCrudReply() {
        IntStream.rangeClosed(1,1000).forEach(i -> {
            Long bno = (long)(Math.random()*200)+1;

            Crud crud = Crud.builder().bno(bno).build();
            CrudReply crudReply = CrudReply.builder()
                    .content("댓글"+i)
                    .crud(crud)
                    .build();
            crudReplyRepository.save(crudReply);
        });
    }

    @Test
    public void testGetCrudReply(){
        Crud crud=Crud.builder().bno(2L).build();
        List<CrudReply> result=crudReplyRepository.findByCrud(crud);

        result.forEach(crudReply -> {
            System.out.println(crudReply.getRno());
            System.out.println(crudReply.getContent());
        });
    }
}
