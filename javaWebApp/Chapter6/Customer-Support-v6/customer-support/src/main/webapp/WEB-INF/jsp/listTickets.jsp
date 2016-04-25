<!DOCTYPE HTML>
<htm>
    <head>
        <meta charset="UTF-8"/>
        <title>Customer Support</title>
    </head>
    <body>
        <a href="<c:url value="/login.action?logout&action=logout" />">Logout</a>
        <h2>Tickets</h2>
        <p>
            <a href="<c:url value="/tickets.action">
             <c:param name="action" value="createGet"/>
             </c:url>"> Create Tickets</a>
        </p>
        <c:choose>
            <c:when test="${ticketsDataBase.isEmpty()}">
                <p>There are no tickets in the system</p>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="each" items="${ticketDataBase}">
                        <li>
                            #${each.key}: <a href="<c:url value="/tickets.action">
                            <c:param name="action" value="view"/>
                            <c:param name="ticketId" value="${each.key}"/>
                         </c:url>"> ${each.value.subject}</a>(Customer: ${each.value.customerName})
                        </li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>
    </body>
</htm>