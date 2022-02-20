package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CodeHolder {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private static int counter = 0;
    private final int id;
    private String code;
    private LocalDateTime date;

    public CodeHolder(String code) {
        this.code = code;
        this.date = LocalDateTime.now();
        this.id = counter++;
    }

    public CodeHolder() {
        this("// write your code here");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return date.format(formatter);
    }

    @JsonIgnore
    public int getId() {
        return id;
    }
}
