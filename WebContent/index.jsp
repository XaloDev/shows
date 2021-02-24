<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>

<html>
	<head>
		<title>Shows</title>
		<link href="./	./index.css" rel="stylesheet">
	</head>
	<body>
		<jsp:useBean id="showDao" class="daos.ShowDao"/>
		<c:import url="./navbar.jsp"/>
		<h1 class="parteCima agaum">Lista de shows</h1>
		<a href="./criar-show.jsp"><input class="favorite styled parteCima" type="button" value="Criar novo show +"></a>
		<table border="1">
			<tr>
				<td>Nome do Show</td>
				<td>Data do Show</td>
				<td>Bandas</td>
				<td>Local</td>
			</tr>
			<c:forEach var="show" items="${showDao.lista}">
			<tr>
				<td>${show.nome}</td>
				<td>${show.dataFormatada}</td>
				<td>${show.bandas}</td>
				<td>${show.local}</td>
				<td>
					<a href="mvc?logica=RemoveShowLogica&id=${show.id}">remover</a>
				</td>
				<td>
					<a href="mvc?logica=EditaShowLogica&id=${show.id}">editar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>