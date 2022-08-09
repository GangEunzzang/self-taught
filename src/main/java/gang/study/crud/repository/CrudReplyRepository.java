package gang.study.crud.repository;

import gang.study.crud.entity.Crud;
import gang.study.crud.entity.CrudReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudReplyRepository extends JpaRepository<CrudReply, Long> {
    List<CrudReply> findByCrud(Crud crud);
}