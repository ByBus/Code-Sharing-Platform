package platform;

public class HtmlFormatterOutput implements HtmlFormatter {
    private String html = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<span id=\"load_date\">DATE</span>\n" +
            "    <pre id=\"code_snippet\">\n" +
            "CODE" +
            "</pre>\n" +
            "</body>\n" +
            "</html>";

    public HtmlFormatterOutput(CodeHolder codeHolder) {
        html = html.replace("CODE", codeHolder.getCode())
                .replace("DATE", codeHolder.getDate());
    }

    @Override
    public String getHtml() {
        return html;
    }
}
