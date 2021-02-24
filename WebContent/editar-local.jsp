<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Editar local</title>
		<link href="./editar-local.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="./navbar.jsp"/>
		<form   action="mvc?logica=SalvarLocalLogica&id=${idLocal}" method="POST">
			<label for="nome"> Nome do local: </label><br/>
			<input type="text" name="nome" value="${nomeLocal}"/><br/>
			<label for="endereco">Endereço: </label><br/>
			<input type="text" name="endereco" value="${enderecoLocal}"/><br/>
			<label for="capacidade">Capacidade: </label><br/>
			<input type="text" name="capacidade" value="${capacidadeLocal}"/><br/>
			<input type="submit" value="Editar local"/>
		</form>
	</body>
</html>