<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="ContactRequestJava.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%

ContactRequestDAO cdao = new ContactRequestDAO();
List<ContactRequest> crs = cdao.getRequests();
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
				<h1>Contact Requests</h1>
			</div>
			
			<div class="row">        	
	        	<div class="col-xs-12">
	        		
					 <table class="table table-striped">
					    <thead>
					      <tr>
					        <th>#</th>
					        <th>Shipowner id</th>
					        <th>Crew id</th>
					        <th>Starting period</th>
					        <th>Ending period</th>
					        <th>Departure point</th>
					        <th>Description</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<% for (ContactRequest cr : crs) {%>
					      <tr>
					      	<td><%=n %></td>
					        <td><%=cr.getShipowner_id() %></td>
					        <td><%=cr.getCrew_id() %></td>
					        <td><%=cr.getStart() %></td>
					        <td><%=cr.getEnd() %></td>
					        <td><%=cr.getDeparture() %></td>
					        <td><%=cr.getDescription() %></td>
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


