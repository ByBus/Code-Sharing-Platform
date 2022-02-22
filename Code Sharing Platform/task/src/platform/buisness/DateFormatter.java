package platform.buisness;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateFormatter implements Formatter {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Override
    public String format(LocalDateTime date) {
        return date.format(formatter);
    }
}
