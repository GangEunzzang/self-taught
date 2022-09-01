package gang.study.crud.file.domain.repository;

import gang.study.crud.file.domain.entity.BasicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicCategoryRepository extends JpaRepository<BasicCategory, Long> {
}