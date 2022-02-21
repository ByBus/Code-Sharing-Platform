<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="/css/style.css" rel="stylesheet"  type="text/css" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <div class = "container">
        <div class = "inner">
            <#list codeHolders as codeHolder>
                <div class = "codeWrapper">
                    <span id="load_date">${codeHolder.date}</span>
                    <pre id="code_snippet" class="codeBlock"><code>${codeHolder.code}</code></pre>
                </div>
            </#list>
        </div>
    </div>
</body>
</html>