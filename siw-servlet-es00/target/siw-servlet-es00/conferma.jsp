<!DOCTYPE html>
<html>
<head>
<title>conferma persona</title>
</head>
<body>
	<h2>Hai inserito questi dati:</h2>
	<div>Nome: ${persona.nome}</div>
	<div>Cognome: ${persona.cognome}</div>
	<div>
		<form action="controller" method="post">
			<input type="submit" name="submit" value="conferma" /> 
			<input type="submit" name="submit" value="torna indietro" />
		</form>
	</div>
</body>
</html>