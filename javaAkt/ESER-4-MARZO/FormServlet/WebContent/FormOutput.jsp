<html>
<head>
<title>Order Form</title></head>
</head>
<body><h1>Order Form</h1>
<table>

<tr>
<td>Messaggio servlet:</td>
<td>${requestScope.bello}</td>

</tr>

<tr>
<td>Name:</td>
<td><%=request.getParameter("name")%></td>

</tr>

<tr>
<td>Name:</td>
<td>${param.name}</td>

</tr>

<tr>
<td>Name:</td>
<td>${param["name"]}</td>

</tr>
<tr>
<td>Address:</td>
<td>${param.address}</td>

</tr>
<tr>
<td>Country:</td>
<td>${param["country"]}</td>

</tr>

<tr>
<td>Shipping Instructions:</td>
<%
	out.write("<td>");
    for (String s: request.getParameterValues("instruction"))  {
        out.write(s+"<br/>");
    };
    out.write("</td>");
%>
</tr>

</table>

<br>
<a href='OrderForm.jsp' >Modulo ordine </a>

</body>
</html>
