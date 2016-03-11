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
					<select name="code" id="code">
						<c:forEach items="${requestScope.codes}" var="code">
							<option value="${code.key}" selected="${code.key eq requestScope.vendita.code}">${code.key}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="qty">Quantita</label>
					<input name="qty" id="qty" type="number" value="${requestScope.vendita.qty}"/>
				</p>
				<p>
					<label for="bill">Numero Ricevuta</label>
					<input name="bill" id="bill" type="text" value="${requestScope.vendita.bill}"/>
				</p>
				
				<p>
					<button type="submit">Vendi</button>
				</p>
			</form>
		</section>
	</body>
</html>