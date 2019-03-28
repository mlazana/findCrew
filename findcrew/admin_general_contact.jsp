<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="GeneralContactJava.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%

GeneralContactDAO gdao = new GeneralContactDAO();
List<GeneralContact> gcs = gdao.getContacts();
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
				<h1>General Contacts</h1>
			</div>
			
			<div class="row">        	
	        	<div class="col-xs-12">
	        		
					 <table class="table table-striped">
					    <thead>
					      <tr>
					        <th>#</th>
					        <th>Name</th>
					        <th>Surname</th>
					        <th>Email</th>
					        <th>Comment</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<% for (GeneralContact gc : gcs ) {%>
					      <tr>
					      	<td><%=n %></td>
					        <td><%=gc.getName() %></td>
					        <td><%=gc.getSurname() %></td>
					        <td><%=gc.getEmail() %></td>
					        <td><%=gc.getComment() %></td>
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
