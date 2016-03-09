<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Inserisci Veicolo</title>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
	</head>
	<body>
		<section id="group">
			<h1>Inserisci veicolo</h1>
			<c:if test="${requestScope.errors != null}">
				<p>Errori</p>
				<ul>
					<c:forEach var="error" items="${requestScope.errors}">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</c:if>
			<form action="store_veicolo.action" method="post">
					<p>
						<label for="targa">
							Targa: <input name="targa" id="targa" type="text" value="${requestScope.form.targa}" required/>
						</label>
					</p>
					<p>
						<label for="modello">
							Modello: <input name="modello" id="modello" type="text" value="${requestScope.form.modello}" required/>
						</label>
					</p>
					<p>
						<label for="kw">
							Kw: <input name="kw" id="kw" type="number" value="${requestScope.form.kw}" />
						</label>
					</p>
					<p>
						<label for="cilindrata">
							Cilindrata: <input name="cilindrata" id="cilindrata" type="number" value="${requestScope.form.cilindrata}" />
						</label>
					</p>
					<p>
						<label for="velocita">
							Velocita: <input name="velocita" id="velocita" type="number" value="${requestScope.form.velocita}" />
						</label>
					</p>
					<p>
						<label for="posti">
							Posti: <input name="posti" id="posti" type="number" min="0" max="7" value="${requestScope.form.posti}" />
						</label>
					</p>
					<p>
						<label for="categoria">
							Categoria: <input name="categoria" id="categoria" type="text" value="${requestScope.form.cat}" />
						</label>
					</p>
					<fieldset>
						<legend>Combustibile</legend>
						<label>benz</label>
							<input name="combustibile" id="combustibile" type="radio" value="01" />
						<label>diesel</label>
							<input name="combustibile" id="combustibile" type="radio" value="02" />
						<label>benz/gpl</label>
							<input name="combustibile" id="combustibile" type="radio" value="03" />
						<label>metano</label>
							<input name="combustibile" id="combustibile" type="radio" value="04" />
					</fieldset>
					
					<p>
						<label for="imm">
							Immatricolazione: <input name="imm" id="imm" type="date" value="${requestScope.form.immatricolazione}"/> (yyy-mm-dd)
						</label>
					</p>
					<p>
						<button type="submit">Invia</button>
					</p>
					<p>
						<button type="reset">Cancella</button>
					</p>
			</form>
		</section>
	</body>
</html>