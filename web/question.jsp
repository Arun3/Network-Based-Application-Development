<%-- 
    Document   : home
    Created on : Sep 20, 2015, 2:07:42 PM
    Author     : Arun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
	<%@include file="navigation.jsp"%>
	<p class="side_head">
		<span class="side_head1"><strong>Question</strong></span>
	</p>
	<form action="answer" method="post">
	<input type="hidden" name = "studyCode" value="<c:out value="${study.code}"></c:out>">
		<table class="question">
			<tr>
				<td><img class="answer" src="<c:out value="${study.imageURL}"></c:out>"/></td>
				<td>
                                    <p class="question"><c:out value="${study.question}"/> (1- Strongly
						agree to 7- Strongly disagree)</p> 
				<select name="choice">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
				</select>
				</td>
			</tr>
		</table>
		<input class="input" type="submit" value="Submit" />
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>
