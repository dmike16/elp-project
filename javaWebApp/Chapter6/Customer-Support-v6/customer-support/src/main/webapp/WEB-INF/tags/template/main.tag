<%@ tag body-content="scriptless" dynamic-attributes="attrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>
<!DOCTYPE html>
<html <c:forEach items="${attrs}" var="a">
    <c:out value='${a.key} = "${fn:escapeXml(a.value)}"' escapeXml="false"/>
</c:forEach>>
<head>
    <title><c:out value="${fn:trim(pageTitle)}"/></title>
</head>
<body>
<jsp:doBody/>
</body>
</html>