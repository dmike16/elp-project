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
				<li>Categoria: ${requestScope.veicolo.cat}</li>
				<li>Combustibile: ${requestScope.veicolo.comb}</li>
				<li>Cilindrata: ${requestScope.veicolo.cilindrata}</li>
				<li>Velocita: ${requestScope.veicolo.velocita}</li>
				<li>Posti: ${requestScope.veicolo.posti}</li>
			</ul>
			<p><a href="aggiungi_veicolo.action">Aggiungi Veicolo</a></p>
		</section>
	</body>
</html>