package gang.study.crud.querydsl;

import gang.study.crud.dto.CrudDTO;
import gang.study.crud.entity.Crud;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CrudRepositoryCustom {
    List<CrudDTO> search(CrudSearchCondition condition);
}
