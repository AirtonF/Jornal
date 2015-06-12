<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Listar Classificados </h2>

	<table border="1">
		<tr>
			<td><b>Titulo</b></td>
			<td><b>Descrição</b></td>
			<td><b>Preço</b></td>
			<td><b>Autor</b></td>
			<td><b>Telefone</b></td>
		</tr>
		<c:forEach var="classificado" items="${classificados}">
			<tr>
				<td>${classificado.titulo}</td>
				<td>${classificado.texto}</td>
				<td>${classificado.preco}</td>
				<td>${classificado.login}</td>
				<td>${classificado.telefone}</td>
				<td><a href="removerClassificado?id=${classificado.id}">Remover</a></td>
				<td><a href="alterarClassificado?id=${classificado.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>