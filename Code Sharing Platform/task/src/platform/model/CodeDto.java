package platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodeDto {
    private String code;
    private String date;
    private long time;
    private long views;
    @JsonIgnore
    private boolean isViewsLimited;
    @JsonIgnore
    private boolean isTimeLimited;
}
