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
<title>Recommend</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
        <p>
            <span class="side_head1"><strong>Recommend to a friend</strong></span>
	</p>
	<div id="divBody2">
		<a href="main.jsp"> &lt;&lt; Back to the Main Page</a>
                <form action="mail" method="post">
                    <input type="hidden" name="action" value="recommend">
		<table class="form">
			<tr>
				<td class="formRight">Name *</td>
				<td class="formRight"><input class="in1" type="text"></td>
			</tr>
			<tr>
				<td class="formRight">Email *</td>
                                <td class="formRight"><input class="in1" name="email" type="email" value="${email}" readonly></td>
			</tr>
			<tr>
				<td class="formRight">Friend's Email *</td>
				<td class="formRight"><input class="in1" name="to" type="email"></td>
			</tr>
			<tr>
				<td class="formRight"><br>Message *</td>
				<td class="formRight"><br>
				<textarea name="message" class="in2"></textarea></td>
			</tr>

			<tr>
				<td class="formRight">&nbsp;</td>
				<td><br>
				<input class="sb" value="Submit" type="submit"></td>
			</tr>
		</table>
		</form>
		<p class="rec">
			<strong><i>when your friend logs in and participates in
					one user study, you'll get 2 coins bonus</i></strong>
		</p>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>

