package gang.study.crud.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooconRedisRepository extends CrudRepository<CooconRedis, String> {
}
