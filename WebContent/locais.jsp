<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Locais</title>
		<link href="./locais.css" rel="stylesheet">
	</head>
	<body>
		<jsp:useBean id="localDao" class="daos.LocalDao"/>
		<c:import url="./navbar.jsp"/>
		<h1 class="parteCima agaum">Lista de locais</h1>
		<a href="././criar-local.jsp"><input class="favorite styled parteCima" type="button" value="Criar novo local +"></a>
		<table border="1">
			<tr>
				<td>Nome do Local</td>
				<td>Endereço</td>
				<td>Capacidade</td>
			</tr>
			<c:forEach var="local" items="${localDao.lista}">
			<tr>
				<td>${local.nome}</td>
				<td>${local.endereco}</td>
				<td>${local.capacidade}</td>
				<td>
					<a href="mvc?logica=RemoveLocalLogica&id=${local.id}">remover</a>
				</td>
				<td>
					<a href="mvc?logica=EditaLocalLogica&id=${local.id}">editar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>