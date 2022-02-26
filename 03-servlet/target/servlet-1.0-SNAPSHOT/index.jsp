<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Servlet初体验" %>
</h1>
<h2>
    <%= "根据不同的参数类型返回不同的资源" %>
</h2>
<br/>
<ul>
    <li>
        <a href="res?type=html">返回HTML</a>
    </li>
    <li>
        <a href="res?type=json">返回JSON</a>
    </li>
    <li>
        <a href="res?type=img">返回图片</a>
    </li>
</ul>
</body>
</html>