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
    <form action="controllerConferma" method="post">
    <input type="submit" name="submit" value="conferma"/>
    <a href="/index.jsp">Torna indietro</a>
    </form></div>
  </body>
</html>