<%--
  Created by IntelliJ IDEA.
  User: dmike
  Date: 29/06/16
  Time: 19.01
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="sessions" type="java.util.List<org.dmike.chat.ChatSession>"--%>
<template:basic pageTitle="Support Chat" bodyTitle="Support Chat Request">
    <c:choose>
        <c:when test="${fn:length(sessions) == 0}">
            <i>There are no pending request chat</i>
        </c:when>
        <c:otherwise>
            Click on a chat request to accept it:<br/><br/>
            <c:forEach items="${sessions}" var="s">
                <a href="javascript:void 0;"
                   onclick="join(${s.sessionId});">
                    ${s.customerUsername}
                </a>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <script type="text/javascript" language="JavaScript">
        var join = function(id)
        {
            postInvisibleForm(
                    '<c:url value="/chat.action"><c:param name="action" value="postChat"/></c:url> ',
        {type: 'join',chatSessionId: id});
        };
    </script>
</template:basic>
