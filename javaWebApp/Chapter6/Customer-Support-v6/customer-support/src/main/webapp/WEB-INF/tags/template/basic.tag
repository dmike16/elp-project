<%@ tag body-content="scriptless" dynamic-attributes="attrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ attribute name="extraNavigationContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>
<template:main pageTitle="${pageTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <jsp:invoke fragment="extraHeadContent"/>
    </jsp:attribute>
    <jsp:attribute name="navigationContent">
        <a href="<c:url value="tickets.action"/>">List Tickets</a><br/>
        <a href="<c:url value="tickets.action">
        <c:param name="action" value="createGet"/>
        </c:url>">Create Ticket</a><br/>
        <a href="javascript:void 0;"
           onclick="newChat();">Chat with Support</a><br />
        <a href="<c:url value="/chat.action">
            <c:param name="action" value="listChat" />
        </c:url>">View Chat Requests</a><br />
        <a href="<c:url value="/login.action?action=logout&logout"/>">Logout</a>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</template:main>