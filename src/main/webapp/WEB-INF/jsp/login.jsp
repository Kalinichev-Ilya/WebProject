<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>

<body>
${message}
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

</body>

</html>
