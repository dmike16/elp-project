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
				<div>
					<h3>Errori</h3>
					<ul>
						<c:forEach var="error" items="${requestScope.errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<form action="search.action" method="post">
				<p>
					<label for="code">Codice</label>
					<input name="code" id="codice" type="text" value="${requestScope.search.code}"/>
				</p>
				<p>
					<label for="describe">Descrizione</label>
					<textarea name="describe" id="describe" maxlength="20" rows="4" cols="10">${requestScope.search.describe}
					</textarea>
					
				</p>
				<p>
					<button type="submit">Cerca</button>
				</p>
			</form>
		</section>
		<section>
		<h3>Ricerca Veloce</h3>
			<a href="search.action?action=mostSell">Articoli piu venduto</a>
			<c:if test="${requestScope.mostSell != null}">
				<p>${requestScope.mostSell}</p>
			</c:if>
			<a href="search.action?action=lessSell">Articolo Meno venduto</a>
			<c:if test="${requestScope.lessSell != null}">
				<p>${requestScope.lessSell}</p>
			</c:if>
		</section>
	</body>
</html>