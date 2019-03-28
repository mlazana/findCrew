<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="FindCrewJava.*" %>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Apply.*" %>

<%
ApplicationDAO adao = new ApplicationDAO();
List<Application> applications = adao.getApplications();
int n = 1;
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="header.jsp"%>
		<link href="css/main_css.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link href="css/profiles.css" rel="stylesheet">
		<link href="css/admin_button.css" rel="stylesheet">
        
	</head>

 <body>
		
		<div class="container">
			<!-- Page Title -->
			<div class="page-header">
				<h1>CVs</h1>
			</div>
			
			<div class="row">        	
	        	<div class="col-xs-12">
	        		
					 <table class="table table-striped">
					    <thead>
					      <tr>
					        <th>#</th>
					        <th>Name</th>
							<th>Surname</th>
							<th>Profession</th>
							<th>Availability</th>
							<th>Age</th>
							<th>Country</th>
							<th>Gender</th>
							<th>Personal Information</th>
							<th>Education</th>
							<th>Experience</th>
							<th>Languages</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<% for (Application appl : applications) {%>
					      <tr>
					      	<td><%=n %></td>
					        <td><%=appl.getName() %></td>
							<td><%=appl.getSurname() %></td>
							<td><%=appl.getProfession() %></td>
							<td><%=appl.getAvailability() %></td>
							<td><%=appl.getAge() %></td>
							<td><%=appl.getCountry() %></td>
							<td><%=appl.getGender() %></td>
							<td><%=appl.getDescribe() %></td>
							<td><%=appl.getEducation() %></td>
							<td><%=appl.getExperience() %></td>
							<td><%=appl.getLanguages() %></td>
					        <% n = n+1;%>
					      </tr>
					      <% } %>
					    </tbody>
					  </table>
					</div>
                </div>
            </div>

      <p><a href="admin_main.jsp"><button class="button"><h3>Back to main</h3></button></a></p>
    </div>
  </body>       
</html>
