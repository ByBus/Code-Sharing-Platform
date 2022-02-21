package platform.buisness;

import org.springframework.stereotype.Component;
import platform.model.CodeDto;
import platform.model.CodeEntity;

@Component
public class EntityMapper implements Mapper<CodeEntity, CodeDto> {
    @Override
    public CodeDto mapToDTO(CodeEntity entity) {
        CodeDto dto = new CodeDto(entity.getCode());
        dto.setDate(entity.getDate());
        return dto;
    }

    @Override
    public CodeEntity mapToEntity(CodeDto dto) {
        return new CodeEntity(dto.getCode());
    }
}
