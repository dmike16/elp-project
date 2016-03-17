<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Garage</title>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
	<section id="global">
		<h1>Garage</h1>
		<a href="garage_insert.action">Insert</a>
		<section>
			<h2>Veicoli</h2>
			<ul>
				<c:if test="${garage.isEmpty() == false}">
					<c:forEach var="v" items="${garage.get()}">
						<li>${v.targa} | ${v.modello} | ${v.imm} <a href="garage_edit/${v.targa}">Edit</a></li>
					</c:forEach>
				</c:if>
			</ul>
		</section>
	</section>

</body>
</html>