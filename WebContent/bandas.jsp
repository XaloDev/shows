<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>


<html>
	<head>
		<title>Bandas</title>
		<link href="./bandas.css" rel="stylesheet">
	</head>
	<body>
		<jsp:useBean id="bandaDao" class="daos.BandaDao"/>
		<c:import url="./navbar.jsp"/>
		<h1 class="parteCima agaum">Lista de bandas</h1>
		<a href="././criar-banda.jsp"><input class="favorite styled parteCima" type="button" value="Criar nova banda +"></a>
		<table border="1">
			<tr>
				<td>Nome da Banda</td>
				<td>Gênero da Banda</td>
			</tr>
			<c:forEach var="banda" items="${bandaDao.lista}">
			<tr>
				<td>${banda.nome}</td>
				<td>${banda.genero}</td>
				<td>
					<a href="mvc?logica=RemoveBandaLogica&id=${banda.id}">remover</a>
				</td>
				<td>
					<a href="mvc?logica=EditaBandaLogica&id=${banda.id}">editar</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>