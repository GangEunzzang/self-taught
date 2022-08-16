package gang.study.crud.repository;

import gang.study.crud.entity.Crud;
import gang.study.crud.querydsl.CrudRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CrudRepository extends JpaRepository<Crud, Long>, CrudRepositoryCustom {
    Crud findByBno(Long bno);
}
