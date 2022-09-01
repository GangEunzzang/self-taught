package gang.study.crud.repository;

import gang.study.crud.entity.Crud;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CrudRepository extends JpaRepository<Crud, Long> {
    Crud findByBno(Long bno);
}
