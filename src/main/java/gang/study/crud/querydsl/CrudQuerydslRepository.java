//package gang.study.crud.querydsl;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import gang.study.crud.dto.CrudDTO;
//import gang.study.crud.dto.QCrudDTO;
//import gang.study.crud.entity.Crud;
//import gang.study.crud.entity.QCrud;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
//import static gang.study.crud.entity.QCrud.crud;
//
//@Repository
//@RequiredArgsConstructor
//public class CrudQuerydslRepository implements CrudRepositoryCustom{
//
//    private final JPAQueryFactory queryFactory;
//
//    public List<CrudDTO> search(CrudSearchCondition condition) {
//        return queryFactory
//                .select(new QCrudDTO(
//                        crud.bno,
//                        crud.title,
//                        crud.content))
//                .from(crud)
//                .where(
//                        titleEq(condition.getTitle()),
//                        contentEq(condition.getContent())
//                )
//                .fetch();
//    }
//
//    private BooleanExpression titleEq(String title) {
//        return StringUtils.hasText(title) ? crud.title.eq(title) : null ;
//    }
//
//    private BooleanExpression contentEq(String content) {
//        return StringUtils.hasText(content) ? crud.content.eq(content) : null ;
//    }
//}
