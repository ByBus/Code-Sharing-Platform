package platform;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CodeHolder {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    private String code = "// write your code here";

    private LocalDateTime date = LocalDateTime.now();

    public String getCode() {
        return code;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return date.format(formatter);
    }

    public void setCode(String code) {
        this.code = code;
        this.date = LocalDateTime.now();
    }
}
