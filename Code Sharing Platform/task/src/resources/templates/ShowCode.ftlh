<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="/css/style.css" rel="stylesheet"  type="text/css" />
</head>
<body>
<div class = "container">
    <div class = "inner">
        <#list codeHolders as codeHolder>
            <div class = "codeWrapper">
                <span id="load_date">${codeHolder.date}</span>
                <pre id="code_snippet" class="codeBlock">${codeHolder.code}</pre>
            </div>
        </#list>
    </div>
</div>
</body>
</html>