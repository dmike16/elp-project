<%--
  Created by IntelliJ IDEA.
  User: dmike
  Date: 16/04/16
  Time: 17.12
  To change this template use File | Settings | File Templates.
--%>
<template:main pageTitle="Custom Support">
    <p><dm:formatDate value="${date}" type="date" pattern="yyyy/MM/dd"/></p>
    <section>
        <h2>Login</h2>
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
</template:main>