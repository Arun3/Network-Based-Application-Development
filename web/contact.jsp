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
<title>Contact</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
     <p>
            <span class="side_head1"><strong>Contact</strong></span>
	</p>
	<div id="divBody2">
		<a href="main.jsp"> &lt;&lt; Back to the Main Page</a>
		<form action="mail" method="post">
                    
                    <input type="hidden" name="action" value="contact">
			<table class="form">
				<tr>
					<td class="formRight">Name *</td>
					<td class="formRight"><input class="in1" name="name" type="text"></td>
				</tr>
				<tr>
					<td class="formRight">Email *</td>
					<td class="formRight"><input class="in1" name="email" type="eMail"></td>
				</tr>
				<tr>
					<td class="formRight">Message *</td>
					<td class="formRight"><textarea class="msg" name="text"></textarea></td>
				</tr>
				<tr>
					<td class="formRight">&nbsp;</td>
					<td><input class="sb" value="Submit" type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
