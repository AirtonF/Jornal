<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista usuario</title>
</head>
<body>

	<h2>Listar Tarefas </h2>

	<table border="1">
		<tr>
			<td><b>Login</b></td>
			<td><b>Senha</b></td>
			<td><b>Nome</b></td>
			<td>E-mail</td>
		</tr>
		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<td>${usuario.login}</td>
				<td>${usuario.senha}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.emai}</td>
				<td><a href="removerUsuario?login=${tarefa}">Remover</a></td>
				<td><a href="alterarUsuario?login=${tarefa}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>