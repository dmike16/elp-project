<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 24/04/16
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="ticketId" type="java.lang.String"--%>
<%--@elvariable id="ticket" type="org.dmike.Ticket"--%>
<template:basic pageTitle="Custom-Support" bodyTitle="Ticket #${ticketId}: ${ticket.subject}">
    <a href="<c:url value="/login.action?action=logout&logout"/>">Logout</a>
    <div>
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
    </div>
</template:basic>
