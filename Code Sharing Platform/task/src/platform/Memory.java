package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Memory {
    private final List<CodeHolder> saved = new ArrayList<>();
    private final CodeHolder defaultCodeHolder;

    @Autowired
    public Memory(CodeHolder codeHolder) {
        this.defaultCodeHolder = codeHolder;
    }

    public void save(CodeHolder codeHolder) {
        saved.add(0, codeHolder);
    }

    public CodeHolder getLast() {
        return saved.isEmpty() ? defaultCodeHolder : saved.get(0);
    }

    public CodeHolder getNth(int n) {
        return saved.stream()
                .filter(ch -> ch.getId() == n)
                .findFirst()
                .orElse(null);
    }

    public List<CodeHolder> getLastN(int n) {
       return saved.stream().limit(n).collect(Collectors.toList());
    }
}
