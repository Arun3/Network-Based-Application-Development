<%-- 
    Document   : navigation
    Created on : Oct 16, 2015, 4:47:23 PM
    Author     : Arun
--%>





<%@page import="modelClasses.User"%>
<div id="rep">
		<table class="sNavigation">
			<% if(request.getSession(false) != null && session.getAttribute("theUser") !=null){
				User userNav  = (User)session.getAttribute("theUser");
			        
                        %>
			<tr>
				<td class="sNavigation">Coins(<%= userNav.getCoins() %>)</td>
			</tr>
			<tr>
				<td class="sNavigation">Participant(<%= userNav.getParticipants() %>)</td>
			</tr>
			<tr>
				<td class="sNavigation">Participation(<%= userNav.getParticipation() %>)</td>
			</tr>
			<tr>
				<td class="sNavigation">&nbsp;</td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="main.jsp">Home</a></td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="${pageContext.request.contextPath}/participate">Participate</a></td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="${pageContext.request.contextPath}/myStudies">My Studies</a></td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="recommend.jsp">Recommend</a></td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="contact.jsp">Contact</a></td>
			</tr>
			<tr>
				<td class="sNavigation"><a href="login.jsp">Log Out</a></td>
			</tr>
			<%} %>
		</table>
	</div>