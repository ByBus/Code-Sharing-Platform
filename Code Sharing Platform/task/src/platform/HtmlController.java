package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {
    @Autowired
    Memory memory;

    @GetMapping("/code/{n}")
    public String getNCodeSnippetsHtml(Model model, @PathVariable int n) {
        List<CodeHolder> codeSnippets = new ArrayList<>();
        codeSnippets.add(memory.getNth(n));
        model.addAttribute("title", "Code");
        model.addAttribute("codeHolders", codeSnippets);
        return "ShowCode";
    }

    @GetMapping("/code/latest")
    public String getLatest10CodeSnippetsHtml(Model model) {
        List<CodeHolder> codeSnippets = memory.getLastN(10);
        model.addAttribute("title", "Latest");
        model.addAttribute("codeHolders", codeSnippets);
        return "ShowCode";
    }

    @GetMapping("/code/new")
    public String createCodeSnippet(Model model) {
        model.addAttribute("codeHolder", memory.getLast());
        return "CodeInputForm";
    }
}
