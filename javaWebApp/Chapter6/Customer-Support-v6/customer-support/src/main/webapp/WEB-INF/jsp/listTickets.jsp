<!DOCTYPE HTML>
<htm>
    <head>
        <meta charset="UTF-8"/>
        <title>Customer Support</title>
    </head>
    <body>
        <a href="<c:url value="/login.action?action=logout&logout" />">Logout</a>
        <h2>Tickets</h2>
        <p>
            <a href="<c:url value="/tickets.action">
             <c:param name="action" value="create"/>
             </c:url>"> Create Tickets</a>
        </p>
        <c:if test="${ticketsDataBase.isEmpty()}">
            <p>There are no tickets in the system</p>
        </c:if>
        <c:if test="${ticketsDataBase.size() > 0}">
            <ul>
                <c:forEach var="each" items="${ticketDataBase}">
                    <li>
                        #${each.key}: <a href="<c:url value="/tickets.action">
                            <c:param name="action" value="view"/>
                            <c:param name="ticketId" value="${each.key}"/>
                         </c:url>"> ${each.value.subject}</a>(Customer: ${each.customerName}
                    </li>
                </c:forEach>
            </ul>
        </c:if>

    </body>
</htm>