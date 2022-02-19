package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCommandController {
    @Autowired
    CodeHolder codeHolder;

    @GetMapping("/code")
    public ResponseEntity<String> getHTMLWithCodeSnippet() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(new HtmlFormatterOutput(codeHolder).getHtml());
    }

    @GetMapping("/api/code")
    public ResponseEntity<CodeHolder> getCodeSnippetJSON() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=utf-8");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(codeHolder);
    }

    @GetMapping("/code/new")
    public ResponseEntity<String> createCodeSnippet() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(new HtmlFormatterInput(codeHolder).getHtml());
    }

    @PostMapping("/api/code/new")
    public ResponseEntity<String> saveCode(@RequestBody CodeHolder codeHolder) {
        this.codeHolder.setCode(codeHolder.getCode());
        return ResponseEntity.ok().body("{}");
    }
}
