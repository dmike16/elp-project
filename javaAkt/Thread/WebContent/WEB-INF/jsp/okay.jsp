<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Okay</title>
	</head>
	<body>
		<section>
		<h1> Tutto Okay</h1>
		<c:if test=${requestScope.book != null}>
		<p>Libro</p>
		<ul>
			<li>id: ${requestScope.book.id}</li>
			<li>titolo: ${requestScope.book.title}</li>
			<li>autore: ${requestScope.book.author}</li>
			<li>prezzo: ${requestScope.book.price}</li>
		</ul>
		</c:if>
		<c:if test="${requestScope.books != null}">
		<p>Libri</p>
		<ul>
			<c:forEach var="book" items="${requestScope.books}">
				<li>
					<ul>
						<li>${book.id}</li>
						<li>${book.title}</li>
						<li>${book.author}</li>
						<li>${book.price}</li>
					</ul>
				</li>
			</c:forEach>
		</ul>
		</c:if>
		<a href="${requestScope.jsp}">Indietro</a><a href="index.html">Menu</a>
		<c:if test="${requestScope.errors != null}">
			<h4>Waring</h4>
			<ul>
				<c:forEach var="error" items="${requestScope.errors}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</c:if>
		</section>
	</body>
</html>