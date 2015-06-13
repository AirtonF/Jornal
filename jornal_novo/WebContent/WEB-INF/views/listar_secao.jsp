<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Seções</h2>

	<table border="1">
		<tr>
			<td><b>Nome</b></td>
			<td><b>Descrição</b></td>
		</tr>
		<c:forEach var="secao" items="${secaos}">
			<tr>
				<td>${secao.titulo}</td>
				<td>${secao.descricao}</td>
				<td><a href="removerSecao?Secao=${secao}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>