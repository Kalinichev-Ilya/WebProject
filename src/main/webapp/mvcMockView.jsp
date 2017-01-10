<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>expjee</title>
    </head>
    <body>
        <b>MVC Mock View</b>
        <br/>requestAttribute.str = ${requestAttribute.str}
        <br/>requestAttribute.map['key-0'] = ${requestAttribute.map['key-0']}
        <br/>requestAttribute.mockEntityB.str = ${requestAttribute.mockEntityB.str}
        <br/>sessionAttribute.array[1] = ${sessionAttribute.array[1]}
        <br/>servletContextAttributes.list[0] = ${servletContextAttributes.list[0]}
        </hr>
        <jsp:useBean id="pageBean" scope="page" class="com.webproject.entity.MockEntityB">
        <br/>pageBean.str = ${pageBean.str}
        </hr>
        <br/>
        <br/>(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt -10) =
            ${(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt -10)}
        </hr>
        </jsp:useBean>
        <br/>test = ${test}
    </body>
</html>
