package gang.study.crud.file.domain.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import gang.study.crud.file.domain.entity.CooconData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static gang.study.crud.file.domain.entity.QCooconData.cooconData;

@RequiredArgsConstructor
@Repository
public class CooconQueryRepository {

    private final JPAQueryFactory queryFactory;

    public boolean exists(String companyRegisterNum) {
        CooconData CooconData = queryFactory
                .select(cooconData)
                .from(cooconData)
                .where(cooconData.companyRegisterNum.eq(companyRegisterNum))
                .fetchFirst();
        System.out.println("값이 뭐있지 ? " + CooconData);

        return CooconData != null;
        }
}
