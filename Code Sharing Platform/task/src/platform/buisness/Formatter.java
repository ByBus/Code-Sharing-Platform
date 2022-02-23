package platform.buisness;

import java.time.LocalDateTime;

public interface Formatter<T, R> {
    R format(T obj);
}
