<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Carica Articoli</title>
	</head>
	<body>
		<section>
			<h1>Carica Articoli</h1>
			<c:if test="${requestScope.errors != null}">
				<p>
					<h3>Errori</h3>
					<ul>
						<c:forEach var="error" items="${requestScope.errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</p>
			</c:if>
			<form action="upload.action" method="post">
				<p>
					<label for="code">Codice</label>
					<input name="code" id="codice" type="text" required value="${requestScope.articolo.code}"/>
				</p>
				<p>
					<label for="describe">Descrizione</label>
					<textarea name="describe" id="describe" maxlength="20" rows="4" cols="10">${requestScope.articolo.describe}</textarea>
					
				</p>
				<p>
					<label for="instock">Giacenza</label>
					<input name="instock" id="instock" type="number" value="${requestScope.articolo.instock}"/>
				</p>
				<p>
					<label for="price">Prezzo</label>
					<input name="price" id="price" value="${requestScope.articolo.price}"/>
				</p>
				
				<p>
					<button type="submit">Carica</button>
				</p>
			</form>
		</section>
	</body>
</html>