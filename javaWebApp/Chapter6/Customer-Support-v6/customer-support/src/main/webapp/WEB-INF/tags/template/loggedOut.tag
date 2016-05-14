<%@ tag body-content="scriptless" dynamic-attributes="attrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>
<template:main pageTitle="${pageTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet" href="<c:out value="resource/stylesheet/login.css"/>"/>
    </jsp:attribute>
    <jsp:attribute name="navigationContent"/>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</template:main>