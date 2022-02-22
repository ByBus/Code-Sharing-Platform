package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.buisness.Mapper;
import platform.model.CodeDto;
import platform.model.CodeEntity;
import platform.persistence.RepositoryService;
import platform.persistence.exceptions.CodeNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HtmlController {
    RepositoryService repository;
    Mapper<CodeEntity, CodeDto> mapper;

    @Autowired
    public HtmlController(RepositoryService repository,
                          Mapper<CodeEntity, CodeDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/code/{id}")
    public String getNthCodeSnippetHtml(Model model, @PathVariable String id) {
        CodeEntity codeEntity = repository.getNth(id);
        try {
            repository.decrementViewsAndSave(codeEntity);
        } catch (CodeNotFoundException e) {
            return "404";
        }
        List<CodeDto> codeDtos = Collections.singletonList(mapper.mapToDTO(codeEntity));
        model.addAttribute("title", "Code");
        model.addAttribute("codeHolders", codeDtos);
        return "ShowCode";
    }

    @GetMapping("/code/latest")
    public String getLatest10CodeSnippetsHtml(Model model) {
        List<CodeEntity> codeSnippets = repository.getLast10();
        List<CodeDto> codeDtos = codeSnippets.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
        model.addAttribute("title", "Latest");
        model.addAttribute("codeHolders", codeDtos);
        return "ShowCode";
    }

    @GetMapping("/code/new")
    public String createCodeSnippet(Model model) {
        return "CodeInputForm";
    }
}
