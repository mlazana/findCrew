<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="FindCrewJava.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
SubscriberDAO sdao = new SubscriberDAO();
List<Subscriber> subscribers = sdao.getSubscriber();
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
				<h1>Subscribers</h1>
			</div>
			
			<div class="row">        	
	        	<div class="col-xs-12">
	        		
					 <table class="table table-striped">
					    <thead>
					      <tr>
					        <th>#</th>
					        <th>Fullname</th>
					        <th>Email</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<% for (Subscriber subscriber : subscribers) {%>
					      <tr>
					      	<td><%=n %></td>
					        <td><%=subscriber.getFullname() %></td>
					        <td><%=subscriber.getEmail() %></td>
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
