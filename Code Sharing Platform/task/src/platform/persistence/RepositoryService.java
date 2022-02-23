package platform.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.model.CodeEntity;
import platform.persistence.exceptions.CodeNotFoundException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RepositoryService {

    private final CodeRepository repository;

    @Autowired
    public RepositoryService(CodeRepository repository) {
        this.repository = repository;
    }

    public CodeEntity getCodeEntity(String id) {
        return repository.findById(id).orElse(null);
    }

    public CodeEntity save(CodeEntity entity) {
        return repository.save(entity);
    }

    public List<CodeEntity> getLast10() {
        return repository.findFirst10ByIsViewsLimitedFalseAndIsTimeLimitedFalseOrderByDateDesc();
    }

    public void delete(CodeEntity entity) {
        repository.delete(entity);
    }

    public void decrementViewsAndSave(CodeEntity codeEntity) {
        if (codeEntity != null) {
            boolean isTimeExceeded = codeEntity.isTimeLimited() &&
                    ChronoUnit.MILLIS.between(LocalDateTime.now(), codeEntity.getDateLimit()) <= 0;
            boolean isViewsExceeded = codeEntity.isViewsLimited() && codeEntity.getViewLimits() <= 0;
            if (isTimeExceeded || isViewsExceeded) {
                delete(codeEntity);
                throw new CodeNotFoundException("Code Not Found");
            }
            if (codeEntity.isViewsLimited()) {
                codeEntity.setViewLimits(codeEntity.getViewLimits() - 1);
                save(codeEntity);
            }
        } else {
            throw new CodeNotFoundException("Code Not Found");
        }
    }

}
