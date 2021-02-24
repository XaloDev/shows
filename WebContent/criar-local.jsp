<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Criar local</title>
		<link href="./criar-local.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="./navbar.jsp"/>
		<form action="adcionaLocal" method="POST">
			<label for="nome"> Nome do local: </label><br/>
			<input type="text" name="nome"/><br/>
			<label for="endereco">Endereço: </label><br/>
			<input type="text" name="endereco"/><br/>
			<label for="capacidade">Capacidade: </label><br/>
			<input type="text" name="capacidade"/><br/>
			<input type="submit" value="Criar local"/>
		</form>
		
	</body>
</html>