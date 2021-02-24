<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Editar show</title>
		<link href="./editar-show.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="./navbar.jsp"/>
		<form action="mvc?logica=SalvarShowLogica&id=${idShow}" method="POST">
			<label for="nome">Nome do Show: </label><br/>
			<input type="text" name="nome" value="${nomeShow}"/><br/>
			<label for="data">Data do Show: </label><br/>
			<input type="text" name="data" value="${dataShow}"/><br/>
			<label for="bandas">Bandas: </label><br/>
			<input type="text" name="bandas" value="${bandasShow}"/><br/>
			<label for="local">Nome do Local: </label><br/>
			<input type="text" name="local" value="${localShow}"/><br/>
			
			
			<input type="submit" value="Editar Show"/>
		</form>
		
	</body>
</html>