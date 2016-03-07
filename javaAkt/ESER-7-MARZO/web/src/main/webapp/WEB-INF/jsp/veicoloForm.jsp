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
			<form action="store_veicolo.action" method="post">
				<fieldset>
					<legend>Dati</legend>
					<p>
						<label for="targa">
							Targa: <input name="targa" id="targa" type="text" value="${requestScope.veicolo.targa}" required/>
						</label>
					</p>
					<p>
						<label for="modello">
							Modello: <input name="modello" id="modello" type="text" value="${requestScope.veicolo.modello}" required/>
						</label>
					</p>
					<p>
						<label for="kw">
							Kw: <input name="kw" id="kw" type="number" value="${requestScope.veicolo.kw}" />
						</label>
					</p>
					<p>
						<label for="imm">
							Immatricolazione: <input name="imm" id="imm" type="date" error="${requestScope.veicolo.immatricolazione == null}"/> (yyy-mm-dd)
						</label>
					</p>
					<p>
						<button type="submit">Invia</button>
					</p>
				</fieldset>
			</form>
		</section>
	</body>
</html>