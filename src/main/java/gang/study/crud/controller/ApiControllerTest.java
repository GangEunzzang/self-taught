package gang.study.crud.controller;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gang.study.crud.entity.CrudReply;
import gang.study.crud.entity.QCrud;
import gang.study.crud.entity.QCrudReply;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static gang.study.crud.entity.QCrud.crud;
import static gang.study.crud.entity.QCrudReply.crudReply;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApiControllerTest {

    private final QueryRepository queryRepository;

    @GetMapping("/api/test/{title}")
    public List<CrudReply> tests(@PathVariable String title) {
        List<CrudReply> haha2 = queryRepository.haha(title);
        return haha2;


    }



}
