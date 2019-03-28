<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="GeneralContactJava.*" %>

<%
String name = request.getParameter("name");
String surname = request.getParameter("surname");
String email = request.getParameter("email");
String comment = request.getParameter("comment");

GeneralContact gc = new GeneralContact(name,surname,email,comment);

GeneralContactDAO gcdao = new GeneralContactDAO();

try {

 gcdao.sendRequest(gc);

 
%> <jsp:forward page = "contact_success.jsp" /> <%

}catch(Exception e) {
	
%> <jsp:forward page = "error.jsp" /> <% 


}


%>

