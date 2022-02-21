package platform.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "CodeSnippet")
public class CodeEntity {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue
    private long id;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;

    private String code;

    public CodeEntity(String code) {
        this.code = code;
    }

    public CodeEntity() { }

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
    public long getId() {
        return id;
    }
}
