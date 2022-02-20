package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestCommandController {
    @Autowired
    Memory memory;

    @GetMapping("/api/code/{n}")
    public ResponseEntity<CodeHolder> getNCodeSnippets(@PathVariable int n) {
        CodeHolder codeHolder = memory.getNth(n);
        return ResponseEntity.ok(codeHolder);
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<List<CodeHolder>> getLatest10CodeSnippets() {
        List<CodeHolder> codeSnippets = memory.getLastN(10);
        return ResponseEntity.ok(codeSnippets);

    }

    @PostMapping("/api/code/new")
    public ResponseEntity<IdDto> saveCode(@RequestBody CodeHolderDto codeHolderDto) {
        CodeHolder codeHolder = new CodeHolder(codeHolderDto.getCode());
        memory.save(codeHolder);
        return ResponseEntity.ok().body(new IdDto(codeHolder.getId()));
    }
}
