

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
    <%@include file="header.jsp" %>
	<div id="divBody2">
		<form action="userController" method="post">
                    <input type="hidden" name="token" value="${param.token}">
			<input type="hidden" name="action" value="login"> <br> <br>
                       
			<table class="form">
				<tr>
					<td class="formRight">Email Address *</td>
					<td class="formRight"><input class="in1" type="email"
						name="email"></td>
				</tr>
				<tr>
					<td class="formRight">Password *</td>
					<td class="formRight"><input class="in1" type="password"
						name="password"></td>
				</tr>
				<tr>
					<td class="formRight">&nbsp;</td>
					<td><input class="sb" value="Log in" type="submit"></td>
				</tr>
			</table>
                        <p class="rec">${message}</p>
			<br> <br> <br> <a class="signup" href="signup.jsp">Sign
                            up for a new account</a>
                        <a class="signup" href="forgotPwd.jsp">Forgot Password</a>
                        
                        
                         
		</form>
             
           
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
