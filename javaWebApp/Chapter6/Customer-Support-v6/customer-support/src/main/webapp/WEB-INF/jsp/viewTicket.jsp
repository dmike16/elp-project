<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 24/04/16
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Customer Support</title>
</head>
<body>
    <a href="<c:url value="/login.action?action=logout&logout"/>">Logout</a>
    <section>
        <h2>Ticket ${ticketId}: ${ticket.subject}</h2>
        <p>
            <i>Customer Name - ${ticket.customerName}</i>
        </p>
        <c:if test="${ticket.getNumberOfAttachments() > 0}">
            <ul>
                <c:forEach var="a" items="${ticket.attachments}">
                    <li>
                        <a href="<c:url value="/tickets.action">
                            <c:param name="action" value="download"/>
                            <c:param name="ticketId" value="${ticketId}"/>
                            <c:param name="attachment" value="${a.name}"/>
                        </c:url>">${a.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <a href="<c:url value="/tickets.action"/>">Return to list tickets</a>
    </section>
</body>
</html>
