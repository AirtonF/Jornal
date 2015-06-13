<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="inserirSecao" method="POST">
		<table>
			<tr>
				<td>Titulo</td><td><input type="text" name="titulo" /></td>
			</tr>
			<tr>
				<td>Descrição</td><td><input type="text" name="descricao" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
	</form>


</body>
</html>