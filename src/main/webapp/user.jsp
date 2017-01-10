<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.webproject.entity.User" %>
<html>
<head>
    <title>expjee</title>
</head>
<body>
<b>PRODUCT PAGE</b>
<br/>id: ${product.id}
        <br/>id: <%=((User)request.getAttribute("product")).getId()%>
        <br/>id: ${product.name}
        <br/><a href="/index.jsp">main page</a>
    </body>
</html>
