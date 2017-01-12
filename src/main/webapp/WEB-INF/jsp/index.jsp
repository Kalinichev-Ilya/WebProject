<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Web Project</title>
</head>

<body>

<form action="/signup" method="post">
    <label for="login"> Логин </label>
    <input type="text" name="login" id="login"/>
    <label for="password"> Пароль </label>
    <input type="text" name="password" id="password"/>
    <label for="confirm_password"> Пароль </label>
    <input type="text" name="confirm_password" id="confirm_password"/>
    <button type="submit">Зарегестрироваться</button>
</form>

</body>

</html>
