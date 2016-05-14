<%--
  Created by IntelliJ IDEA.
  User: dmike
  Date: 16/04/16
  Time: 17.12
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="errors" type="java.util.Map"--%>
<%--@elvariable id="date" type="java.util.Date"--%>
<%--@elvariable id="inValue" type="java.lang.String"--%>
<template:loggedOut pageTitle="Custom Support" bodyTitle="Log In">
    <p><dm:formatDate value="${date}" type="date" /></p>
    <section>
        <form method="post" action = "<c:url value="login.action">
            <c:param name="action" value="login"/>
        </c:url>">
            <p>
                <label for="username">Username</label>
                <input id="username" name="username" type="text" value="${fn:escapeXml(inValue)}"/>
                <span>${errors.username}</span>
            </p>
            <p>
                <label for="password">Password</label>
                <input id="password" name="password" type="password" />
                <span>${errors.password}</span>
            </p>
            <button type="submit" >Login</button>

        </form>
    </section>
</template:loggedOut>