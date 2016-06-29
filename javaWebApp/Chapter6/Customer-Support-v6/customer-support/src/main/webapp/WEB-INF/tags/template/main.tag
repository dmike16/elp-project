<%@ tag body-content="scriptless" dynamic-attributes="attrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true" required="true" %>
<%@ attribute name="headContent" fragment="true" required="false" %>
<%@ attribute name="navigationContent" fragment="true" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>
<!DOCTYPE html>
<html <c:forEach items="${attrs}" var="a">
    <c:out value='${a.key} = "${fn:escapeXml(a.value)}"' escapeXml="false"/>
</c:forEach>>
<head>
    <title><c:out value="${fn:trim(pageTitle)}"/></title>
    <link rel="stylesheet" href="<c:out value="resource/stylesheet/main.css"/>"/>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
    <script type="text/javascript" lang="javascript">
        var postInvisibleForm = function(url, fields) {
            var form = $('<form id="mapForm" method="post"></form>')
                    .attr({ action: url, style: 'display: none;' });
            for(var key in fields) {
                if(fields.hasOwnProperty(key))
                    form.append($('<input type="hidden">').attr({
                        name: key, value: fields[key]
                    }));
            }
            $('body').append(form);
            form.submit();
        };
        var newChat = function() {
            postInvisibleForm(
                    '<c:url value="/chat.action" ><c:param name="action" value="postChat"/></c:url>'
            , { type: 'new' });
        };
    </script>
    <jsp:invoke fragment="headContent"/>
</head>
<body>
<section id="bodyTable">
    <h1>Multinational Widget Corporation</h1>
    <nav class="sidebarCell">
        <jsp:invoke fragment="navigationContent"/>
    </nav>
    <section class="contentCell">
        <h2><c:out value="${fn:trim(bodyTitle)}"/></h2>
        <jsp:doBody />
    </section>
</section>
</body>
</html>