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

    @GetMapping("/code/{n}")
    public String getNthCodeSnippetHtml(Model model, @PathVariable long n) {
        List<CodeDto> codeSnippets = Collections.singletonList(mapper.mapToDTO(repository.getNth(n)));
        model.addAttribute("title", "Code");
        model.addAttribute("codeHolders", codeSnippets);
        return "ShowCode";
    }

    @GetMapping("/code/latest")
    public String getLatest10CodeSnippetsHtml(Model model) {
        List<CodeEntity> codeSnippets = repository.getLast10();
        List<CodeDto> codeDTOS = codeSnippets.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
        model.addAttribute("title", "Latest");
        model.addAttribute("codeHolders", codeDTOS);
        return "ShowCode";
    }

    @GetMapping("/code/new")
    public String createCodeSnippet(Model model) {
        return "CodeInputForm";
    }
}
