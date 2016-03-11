<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Cerca Libro</title>
	</head>
	<body>
		<section>
			<c:if test="${requestScope.errors != null}">
				<section>
					<h2>Errors</h2>
					<ul>
						<c:forEach var="error" items="${requestScope.errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</section>
			</c:if>
		<h1> Search Form</h1>
		<form	action="consulta.action" method="post">
			<p>
				<label for="idlibro">Id</label>
				<input name="idlibro" id="idlibro" type="text" value="${requestScope.search.id}"/>
			</p>
			
			<p>
				<button type="submit">Cerca</button>
			</p>
		</form>
		</section>
	</body>

</html>