package platform.model;

public class IdDto {
    private final String id;

    public IdDto(long id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }
}
