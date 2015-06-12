<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Listar Noticias </h2>

	<table border="1">
		<tr>
			<td><b>Titulo</b></td>
			<td><b>Sub-Titulo</b></td>
			<td><b>Texto</b></td>
			<td><b>Autor</b></td>
		</tr>
		<c:forEach var="noticia" items="${noticias}">
			<tr>
				<td>${noticia.titulo}</td>
				<td>${noticia.subtitulo}</td>
				<td>${noticia.texto}</td>
				<td>${classificado.login}</td>
				<td><a href="removerNoticia?id=${classificado.id}">Remover</a></td>
				<td><a href="alterarNoticia?id=${classificado.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>