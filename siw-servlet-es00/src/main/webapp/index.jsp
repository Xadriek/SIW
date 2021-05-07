<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Prima Webapp</title>
</head>
<body>
	<form action="controller" method="post">
		<div>Nome: <input type="text" name="nome" value="${persona.nome}"/></div>
		<div>${errori["nome"]}</div>
		<div>Cognome: <input type="text" name="cognome" value="${persona.cognome}" /></div>
		<div>${errori["cognome"]}</div>
		<div><input type="submit" name="submit" value="invia" /></div>
	</form>
</body>
</html>