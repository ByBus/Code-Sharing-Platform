package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.buisness.Mapper;
import platform.model.CodeDto;
import platform.model.CodeEntity;
import platform.model.IdDto;
import platform.persistence.RepositoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestCommandController {
    RepositoryService repository;
    Mapper<CodeEntity, CodeDto> mapper;

    @Autowired
    public RestCommandController(RepositoryService repository,
                                 Mapper<CodeEntity, CodeDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity<CodeDto> getNCodeSnippets(@PathVariable String id) {
        CodeEntity codeEntity = repository.getNth(id);
        repository.decrementViewsAndSave(codeEntity);
        return ResponseEntity.ok(mapper.mapToDTO(codeEntity));
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<List<CodeDto>> getLatest10CodeSnippets() {
        List<CodeEntity> codeSnippets = repository.getLast10();
        List<CodeDto> codeDTOS = codeSnippets.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(codeDTOS);

    }

    @PostMapping("/api/code/new")
    public ResponseEntity<IdDto> saveCode(@RequestBody CodeDto codeDto) {
        CodeEntity codeEntity = repository.save(mapper.mapToEntity(codeDto));
        return ResponseEntity.ok().body(new IdDto(codeEntity.getId()));
    }
}
