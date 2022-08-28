package gang.study.crud.file.domain.repository;

import gang.study.crud.file.domain.entity.CooconData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

public interface CooconDataRepository extends JpaRepository<CooconData, Long> {

}