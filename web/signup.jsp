<%-- 
    Document   : home
    Created on : Sep 20, 2015, 2:07:42 PM
    Author     : Arun
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
	<div id="divBody2">
		<form action="userController" method="post">
                    <input type="hidden" name="action" value="create">
                    <input type="hidden" name="token" value="${param.token}"><br>
			<br> <br>
			<table class="form">
                            
				<tr>
					<td class="formRight">Name *</td>
					<td class="formRight"><input class="in1" type="text" name="name"></td>
				</tr>
				<tr>
					<td class="formRight">Email *</td>
					<td class="formRight"><input class="in1" type="eMail" name="email"></td>
				</tr>
				<tr>
					<td class="formRight">Password *</td>
					<td class="formRight"><input class="in1" type="password" name="password"></td>
				</tr>
				<tr>
					<td class="formRight">Confirm Password *</td>
					<td class="formRight"><input class="in1" type="password" name="confirmpassword"></td>
				</tr>
				<tr>
					<td class="formRight">&nbsp;</td>
					<td><input class="sb" value="Create Account" type="submit"></td>
				</tr>
			</table>
                       <p class="rec">${message}</p>
                        
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
