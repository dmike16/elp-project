<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Vendi Articoli</title>
	</head>
	<body>
		<section>
			<h1>Vendi Articoli</h1>
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
			<form action="sell.action" method="post">
				<p>
					<label for="code">Codice</label>
					<input name="code" id="codice" type="text" required/>
				</p>
				<p>
					<label for="qty">Quantità</label>
					<input name="qty" id="qty" type="number"/>
				</p>
				<p>
					<label for="bill">Prezzo</label>
					<input name="bill" id="bill" type="text"/>
				</p>
				
				<p>
					<button type="submit">Vendi</button>
				</p>
			</form>
		</section>
	</body>
</html>