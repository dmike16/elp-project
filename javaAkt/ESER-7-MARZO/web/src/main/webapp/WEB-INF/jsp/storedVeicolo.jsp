<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Veicolo</title>
	</head>
	<body>
		<section>
			<h1>Dati Veicolo</h1>
			<ul>
				<li>Targa: ${requestScope.veicolo.targa}</li>
				<li>Modello: ${requestScope['veicolo'].modello}</li>
				<li>Kw: ${requestScope['veicolo'].kw} kw</li>
				<li>Immatricolazione: ${requestScope.veicolo.immatricolazione}</li>
			</ul>
		</section>
	</body>
</html>