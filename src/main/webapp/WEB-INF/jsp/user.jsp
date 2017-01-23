<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Hello ${user}!</h1>
<h1>Login was successful</h1>
<table border="1" cellpadding="5">
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <br>
        <tr>
            <td>${login}</td>
            <td>${password}</td>
        </tr>

</table>
</body>
</html>
