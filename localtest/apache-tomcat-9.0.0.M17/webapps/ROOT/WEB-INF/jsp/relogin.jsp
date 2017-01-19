<%--
  Created by IntelliJ IDEA.
  User: Vovchik
  Date: 19.01.2017
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relogin page</title>
</head>
<body>
<h1>Relogin for continue</h1>
${error}
${message}
<br>
<form action="/login" method="post">
    <ul>
        <li>
            <label for="login"> Login </label>
            <input type="text" name="login" id="login"/>
        </li>
        <li>
            <label for="pwd"> Password </label>
            <input type="text" name="pwd" id="pwd"/>
        </li>
        <li>
            <button type="submit">Log in</button>
        </li>
    </ul>
</form>
</html>
