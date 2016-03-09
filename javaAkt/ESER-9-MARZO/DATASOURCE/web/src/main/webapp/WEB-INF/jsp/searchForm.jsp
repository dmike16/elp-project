<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Cerca Articoli</title>
	</head>
	<body>
		<section>
			<h1>Cerca Articoli</h1>
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
			<form action="search.action" method="post">
				<p>
					<label for="code">Codice</label>
					<input name="code" id="codice" type="text" required/>
				</p>
				<p>
					<label for="describe">Descrizione</label>
					<textarea name="describe" id="describe" maxlength="20" rows="4" cols="10">
					Max 20 Char
					</textarea>
					
				</p>
				<p>
					<button type="submit">Cerca</button>
				</p>
			</form>
		</section>
		<section>
			<h3>Articoli piu venduto</h3>
			<p>${requestScope.mostSell}</p>
			<h3>Articolo Meno venduto</h3>
			<p>${requestScope.lessSell}</p>
		</section>
	</body>
</html>