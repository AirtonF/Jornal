<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Usuario</title>
</head>
<body>

<form action="inserirUsuario" method="POST">
		<table>
			<tr>
				<td>Login</td><td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Senha</td><td><input type="text" name="senha" /></td>
			</tr>
			<tr>
				<td>Nome</td><td><input type="text" name="nome" /></td>
			</tr>
			<tr>	
				<td>E-mail</td><td><input type="text"	name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>