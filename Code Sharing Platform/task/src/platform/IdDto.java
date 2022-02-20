package platform;

public class IdDto {
    private String id;

    public IdDto(int id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }
}
