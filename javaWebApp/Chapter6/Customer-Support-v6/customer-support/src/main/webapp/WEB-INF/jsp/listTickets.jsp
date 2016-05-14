<%--@elvariable id="ticketDataBase" type="java.util.Map"--%>
<template:basic pageTitle="Custom Support" bodyTitle="Tickets">
    <p>
        <a href="<c:url value="/tickets.action">
             <c:param name="action" value="createGet"/>
             </c:url>"> Create Tickets</a>
    </p>
    <c:choose>
        <c:when test="${ticketDataBase.isEmpty()}">
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
</template:basic>