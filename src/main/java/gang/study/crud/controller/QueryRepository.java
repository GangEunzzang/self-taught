package gang.study.crud.controller;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gang.study.crud.entity.CrudReply;
import gang.study.crud.entity.QCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gang.study.crud.entity.QCrud.*;
import static gang.study.crud.entity.QCrudReply.crudReply;

@Repository
@RequiredArgsConstructor
public class QueryRepository {
    private final JPAQueryFactory queryFactory;
    public List<CrudReply> haha(String title) {

        return queryFactory
                .selectFrom(crudReply)
                .leftJoin(crudReply.crud, crud)
                .where(crudReply.crud.title.eq(title))
                .fetch();
    };
}
