<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="listUsers" dataSource="jdbc/webprojectDB">
    select USER_NAME, USER_PASS from USERS;
</sql:query>

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
    <c:forEach var="user" items="${listUsers.rows}">
        <tr>
            <td><c:out value="${users.login}"/></td>
            <td><c:out value="${users.password}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
