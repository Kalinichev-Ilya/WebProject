<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="listUsers" dataSource="jdbc/UsersDB">
    select login, password from users;
</sql:query>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Login was successful</h1>
<table border="1" cellpadding="5">
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <br>
    <c:forEach var="user" items="${listUsers.rows}">
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
