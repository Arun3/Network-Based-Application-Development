

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
                       <input type="hidden" name="action" value="updatePwd"> <br> <br>
                       <input type="hidden" name="token" value="${param.token}"><br>
			<table class="form">
				<tr>
					<td class="formRight">Email Address *</td>
					<td class="formRight">${user.email}</td>
				</tr>
                                <tr>
					<td class="formRight">Enter Password</td>
                                        <td class="formRight"><input class="in1" type="password"
						name="password"></td>
					
				</tr>
                                 <tr>
					<td class="formRight">Confirm Password</td>
                                        <td class="formRight"><input class="in1" type="password"
						name="confirmPassword"></td>
					
				</tr>
                                <tr>
                                    <td class="formRight">&nbsp;</td>
                                    <td><input class="sb" value="Reset" type="submit"></td>
                                </tr>
				
			</table>
                        <p class="rec">${message}</p>
			
                        
                        
                         
		</form>
             
           
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
