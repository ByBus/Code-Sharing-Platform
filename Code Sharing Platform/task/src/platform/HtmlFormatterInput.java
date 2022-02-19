package platform;

public class HtmlFormatterInput implements HtmlFormatter{
    private String html = "<html>" +
            "<head>\n" +
            "    <title>Create</title>" +
            "</head>" +
            "<body>" +
            "<textarea id=\"code_snippet\">CODE</textarea>" +
            "<br>" +
            "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" +
            "</body>" +
            "<script>" +
            "function send() {\n" +
            "    let object = {\n" +
            "        \"code\": document.getElementById(\"code_snippet\").value\n" +
            "    };\n" +
            "    \n" +
            "    let json = JSON.stringify(object);\n" +
            "    \n" +
            "    let xhr = new XMLHttpRequest();\n" +
            "    xhr.open(\"POST\", '/api/code/new', false)\n" +
            "    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
            "    xhr.send(json);\n" +
            "    \n" +
            "    if (xhr.status == 200) {\n" +
            "      alert(\"Success!\");\n" +
            "    }\n" +
            "}\n" +
            "</script>"+
            "</html>";

    public HtmlFormatterInput(CodeHolder codeHolder) {
        html = html.replace("CODE", codeHolder.getCode());
    }

    @Override
    public String getHtml() {
        return html;
    }

}
