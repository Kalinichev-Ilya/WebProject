<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Hello!</h1>

<br>
Log in to continue.
${message}
${error}
<form action="/" method="post">
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

<br>
If you are for the fist time please sign up.

<form action="/" method="post">
    <ul>
        <li>
            <label for="login"> Login </label>
            <input type="text" name="login" id="reg_login"/>
        </li>
        <li>
            <label for="pwd"> Password </label>
            <input type="text" name="pwd" id="reg_pwd"/>
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