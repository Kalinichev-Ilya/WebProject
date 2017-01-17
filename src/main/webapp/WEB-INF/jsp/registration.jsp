<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>

${messageFilter}
<br>

<form action="/registration" method="post">
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
            <label for="pwd_rpt"> Repeat password </label>
            <input type="text" name="pwd_rpt" id="pwd_rpt"/>
        </li>
        <li>
            <button type="submit">Sign up</button>
        </li>
    </ul>
</form>
</body>
</html>
