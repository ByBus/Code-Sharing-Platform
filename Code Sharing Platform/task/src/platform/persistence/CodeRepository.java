package platform.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.CodeEntity;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<CodeEntity, String> {
    List<CodeEntity> findFirst10ByOrderByDateDesc();

    List<CodeEntity> findFirst10ByIsViewsLimitedFalseAndIsTimeLimitedFalseOrderByDateDesc();
}
