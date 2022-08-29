package gang.study.crud.file.domain.repository;

import gang.study.crud.file.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

}