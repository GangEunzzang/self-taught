package gang.study.crud.repository;

import gang.study.crud.entity.CrudReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudReplyRepository extends JpaRepository<CrudReply, Long> {
}