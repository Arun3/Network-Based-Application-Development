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
<title>Participate</title>
<link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
	<%@include file="header2.jsp"%>
	<%@include file="navigation.jsp"%>
	<p class="side_head">
		<span class="side_head1"><strong>Participate</strong></span>
	</p>
	<form action="participate" method="post">
		<div id="divBody2">

			<table>
				<tbody>
						<tr>
							<td class="head">Study Name</td>
							<td class="head">Image</td>
							<td class="head">Question</td>
							<td class="head">Action</td>
						</tr>
						<c:forEach var="study" items="${result}"
							varStatus="loop"> 
							<%-- <tr class="${loop.index % 2 == 0 ? 'cell1' : 'cell2'}"> --%>
							<tr>
                                                            <td><c:out value="${study.name}"/></td>
								<td><img class="edit" src="${study.imageURL}" alt="welcome"/></td>
                                                                <td><c:out value="${study.question}"/></td>
								<td><button class="stud" type="submit" name="studyCode" value="${study.code}">Participate</button></td>
							</tr>
						</c:forEach>
						
						<!-- <tr>
							<td class="cell1">GUI</td>
							<td class="cell1"><img src="images/tree2.jpg" alt="tree" /></td>
							<td class="cell1">I enjoy outdoor activities</td>
							<td class="cell1"><input type="submit" value="Participate"></td>
						</tr>
						<tr>
							<td class="cell2">Sec</td>
							<td class="cell2"><img
								src="images/computer.jpg" alt="computer" /></td>
							<td class="cell2">I use computers in a daily basis</td>
							<td class="cell2"><input type="submit" value="Participate"></td>
						</tr>
						<tr>
							<td class="cell1">&nbsp;</td>
							<td class="cell1">&nbsp;</td>
							<td class="cell1">&nbsp;</td>
							<td class="cell1">&nbsp;</td>
						</tr>
						<tr>
							<td class="cell2">&nbsp;</td>
							<td class="cell2">&nbsp;</td>
							<td class="cell2">&nbsp;</td>
							<td class="cell2">&nbsp;</td>
						</tr> -->
				</tbody>
			</table>
		</div>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>
