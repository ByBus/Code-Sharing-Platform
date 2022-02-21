package platform.model;

public class CodeDto {
    private String code = "";
    private String date = "";

    public CodeDto(String code) {
        this.code = code;
    }

    public CodeDto() { }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
