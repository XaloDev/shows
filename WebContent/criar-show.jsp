<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Criar show</title>
		<link href="./criar-show.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="./navbar.jsp"/>
		<form action="adcionaShow" method="POST">
			<label for="nome">Nome do Show: </label><br/>
			<input type="text" name="nome"/><br/>
			<label for="data">Data do Show: </label><br/>
			<input type="text" name="data"/><br/>
			<label for="bandas">Bandas: </label><br/>
			<input type="text" name="bandas"/><br/>
			<label for="local">Nome do Local: </label><br/>
			<input type="text" name="local"/><br/>
			
			
			<input type="submit" value="Criar Show"/>
		</form>
		
	</body>
</html>