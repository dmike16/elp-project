<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<section id="global">
		<h1>Insert Veicol Form</h1>
		<form:form commandName="veicol">
			<fieldset>
				<p><form:errors path="targa"/>
				<label for="targa"> Targa <form:input id="targa" path="targa" />
				</label>
				</p> 
				<p><form:errors path="modello"/>
				<label for="modello"> Modello <form:input id="modello"
						path="modello" />
				</label> 
				</p>
				<p><form:errors path="posti"/>
				<label for="posti"> Posti <form:input id="posti" path="posti" />
				</label> 
				</p>
				<p><form:errors path="maxVel"/>
				<label for="maxVel"> MaxVel <form:input id="maxVel" path="maxVel" />
				</label> 
				</p>
				<p><form:errors path="cilindrata"/>
				<label for="cilindrata"> Cilindrata <form:input id="cilindrata"
						path="cilindrata" />
				</label> 
				</p>
				<p><form:errors path="imm"/>
				<label for="imm"> Immatricolazione <form:input id="imm" type="date"
						path="imm" />
				</label>
				</p>
			</fieldset>
			<button type="submit">Insert</button>
		</form:form>
	</section>

</body>
</html>