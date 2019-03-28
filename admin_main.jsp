<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>


<!DOCTYPE html>
<html lang="en">

  <head>
    <%@ include file="header.jsp"%>
    <link href="css/admin_button.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">
  </head>

<body id="page-top">

    <%@ include file="navigationmenu_shipowner.jsp"%>

    <div class="container">
      <p></p>
	  <h2 class="text-center hidden-xs hidden-sm hidden-md" style="color:#598881"><b>Time to manage FindCrew!</b></h2>

	</div>	
    <p></p>
    <div class="container col-md-2">

 	<p><a href="admin_general_contact.jsp"><button class="button">General Contacts</button></p>
 	<p><a href="admin_contact_request.jsp"><button class="button">Contact Requests</button></a></p>
 	<p><a href="admin_createcv.jsp"><button class="button">Cvs</button></p>
 	<p><a href="admin_subscribers.jsp"><button class="button">Subscriptions</button></p>
       
     </div>
	


  </body>

</html>
