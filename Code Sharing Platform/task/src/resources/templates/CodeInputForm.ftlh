<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link href="/css/style.css" rel="stylesheet"  type="text/css" />
</head>
<body>
    <div class = "container inputCode">
        <div class = "inner">
            <textarea id="code_snippet">// write your code here</textarea>
            <div class="inputContainer">
                <div class="inputWrapper">
                    <label for="time_restriction">Time restriction (seconds)</label>
                    <input id="time_restriction" type="number" value="0" />
                </div>
                <div class="inputWrapper">
                    <label for="views_restriction">Views restriction</label>
                    <input id="views_restriction" type="number" value="0" />
                </div>
            </div>
            <button id="send_snippet" type="submit" onclick="send()">Submit</button>
        </div>
    </div>
</body>
<script type="text/javascript" src="/js/sendScript.js"></script>
</html>