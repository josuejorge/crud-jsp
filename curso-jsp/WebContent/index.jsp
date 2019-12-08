<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="LoginServlet" method="post">
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
	<td><input type="submit" value="logar"></td>
	</tr>
	
	</table>
	
</form>

</body>
</html>