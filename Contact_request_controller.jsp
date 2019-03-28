<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp" %>
<%@ page import="ContactRequestJava.*" %>
<%@ page import="FindCrewJava.*" %>
<%@ page import="LoginJava.*" %>




<%

String start = request.getParameter("start");
String end = request.getParameter("end");
String departure = request.getParameter("departure");
String description = request.getParameter("description");

String crew_id = request.getParameter("crew_id");


UserLogin user = (UserLogin)session.getAttribute("user-object");
int userid = user.getID();

UserLoginDAO udao = new UserLoginDAO();

int shipownerid = udao.getShipownerId(userid);



ContactRequestDAO cdao = new ContactRequestDAO();
ContactRequest cr = new ContactRequest(crew_id, shipownerid, start, end, departure, description);


try{

    cdao.sendRequest(cr); 
%>  
    
	<jsp:forward page = "contact_success.jsp" />
<%
}catch(Exception e) {
	
%> <jsp:forward page = "error_page.jsp" /> <% 


}


%>


