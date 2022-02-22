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
                    <div class="infoBar">
                        <span id="load_date">${codeHolder.date}</span>
                        <#if codeHolder.isTimeLimited()>
                            <div class="restrictionWrapper">
                                <span id="time_restriction">${codeHolder.time}</span>
                                <span class="label">seconds before deletion</span>
                            </div>
                        </#if>
                         <#if codeHolder.isViewsLimited()>
                            <div class="restrictionWrapper">
                                <span id="views_restriction">${codeHolder.views}</span>
                                <span class="label">more views allowed</span>
                            </div>
                        </#if>
                    </div>
                    <pre id="code_snippet" class="codeBlock"><code>${codeHolder.code}</code></pre>
                </div>
            </#list>
        </div>
    </div>
</body>
</html>