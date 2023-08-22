<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<input type="text" id="name" placeholder="Название клуба">
<input type="text" id="year" placeholder="Год основания">
<input type="text" id="lch" placeholder="титулов лч">
<input type="text" id="chemp" placeholder="чемпионств">
<input type="text" id="country" placeholder="страна">
<button onclick="req()">Отправить</button>
<script src="js/writeJson.js"></script>
</body>
</html>