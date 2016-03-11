<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Inserisci Libro</title>
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
		<h1> Insert Form</h1>
		<form	action="insert.action" method="post">
			<p>
				<label for="idlibro">Id</label>
				<input name="idlibro" id="idlibro" type="text" value="${requestScope.book.id}"/>
			</p>
			<p>
				<label for="titolo">Titolo</label>
				<input name="titolo" id="titolo" type="text" value="${requestScope.book.title}"/>
			</p>
			<p>
				<label for="autore">Autore</label>
				<input name="autore" id="autore" type="text" value="${requestScope.book.author}"/>
			</p>
			<p>
				<label for="prezzo">Prezzo</label>
				<input name="prezzo" id="prezzo" type="text" value="${requestScope.book.price}"/>
			</p>
			<p>
				<button type="submit">Carica</button>
			</p>
		</form>
		</section>
	</body>

</html>