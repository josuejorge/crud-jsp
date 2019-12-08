<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuario</title>
</head>
<body>

Cadastrar Usuario

<form action="salvarUsuario" method="post">
<table>
	<tr>
	<td>Login:</td>
	<td><input type="text" id="login" name="login"></td>
	</tr>
	
	<tr>
	<td>Senha:</td>
	<td><input type="password" id="senha" name="senha"></td>
	</tr>
	
	<tr>
	
	<td><input type="submit" value="salvar"></td>
	</tr>
</table>
</form>

<table>

<c:forEach items="${usuarios}" var="user">
<tr>
<td style="width:150px"><c:out value="${user.login}"></c:out></td>
<td style="width:90px"><c:out value="${user.senha}"></c:out></td>
<td><a href="salvarUsuario?acao=delete&user=${user.login}">Excluir</a></td>

<td><a href="salvarUsuario?acao=editar&user=${user.login}">Editar</a></td></tr>
</c:forEach>
</table>

</body>
</html>