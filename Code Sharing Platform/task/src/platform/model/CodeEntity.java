package platform.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CodeSnippet")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CodeEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;

    @NonNull
    private String code;

    @NonNull
    private boolean isViewsLimited;

    @Column(name = "views_left")
    @NonNull
    private long viewLimits;

    @NonNull
    private boolean isTimeLimited;

    @Column(name = "expiration_date")
    @NonNull
    private LocalDateTime dateLimit;
}
