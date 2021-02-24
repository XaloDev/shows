<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Editar banda</title>
		<link href="./editar-banda.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="./navbar.jsp"/>
		<form  action="mvc?logica=SalvarBandaLogica&id=${idBanda}" method="POST">
			<label for="nome"> Nome da banda: </label><br/>
			<input type="text" name="nome" value="${nomeBanda}"/><br/>
			Gênero: <br/>
				<input type="radio" id="axe" name="genero" value="axe">
				<label for="axe">Axé</label><br>
			  <input type="radio" id="forro" name="genero" value="forro">
			  <label for="forro">Forró</label><br>
			  <input type="radio" id="rock" name="genero" value="rock">
			  <label for="rock">Rock</label><br/>
			  <input type="submit" value="Editar banda"/>
			
		</form>
		
	</body>
</html>