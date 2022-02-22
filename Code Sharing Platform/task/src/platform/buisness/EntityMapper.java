package platform.buisness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import platform.model.CodeDto;
import platform.model.CodeEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class EntityMapper implements Mapper<CodeEntity, CodeDto> {


    @Autowired
    Formatter formatter;

    @Override
    public CodeDto mapToDTO(CodeEntity entity) {
        long secondsLeft = !entity.isTimeLimited() ? 0 : ChronoUnit.SECONDS.between(
                LocalDateTime.now(),
                entity.getDateLimit()
        );
        long viewsLeft = !entity.isViewsLimited() ? 0 : entity.getViewLimits();
        return new CodeDto(entity.getCode(),
                formatter.format(entity.getDate()),
                secondsLeft,
                viewsLeft,
                entity.isViewsLimited(),
                entity.isTimeLimited());
    }

    @Override
    public CodeEntity mapToEntity(CodeDto dto) {
        boolean isViewLimited = dto.getViews() > 0;
        boolean isTimeLimited = dto.getTime() > 0;
        return new CodeEntity(dto.getCode(),
                isViewLimited,
                dto.getViews(),
                isTimeLimited,
                LocalDateTime.now().plusSeconds(dto.getTime()));
    }
}
