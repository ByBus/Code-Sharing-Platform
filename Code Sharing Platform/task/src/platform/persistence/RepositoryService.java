package platform.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.model.CodeEntity;

import java.util.List;

@Service
public class RepositoryService {

    private final CodeRepository repository;

    @Autowired
    public RepositoryService(CodeRepository repository) {
        this.repository = repository;
    }

    public CodeEntity getNth(long n) {
        return repository.findById(n).orElse(null);
    }

    public CodeEntity save(CodeEntity entity) {
        return repository.save(entity);
    }

    public List<CodeEntity>  getLast10() {
        return repository.findFirst10ByOrderByDateDesc();
    }
}
