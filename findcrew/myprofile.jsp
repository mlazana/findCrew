<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="LoginJava.*" %>


<!DOCTYPE html>
<html lang="en">

  <head>
	<%@ include file="header.jsp"%>


    
	    

    <!-- Custom styles for this template -->
    <link href="css/individual.css" rel="stylesheet">
    <link href="css/myprofile.css" rel="stylesheet">


  </head>

  <body id="page-top">

	<%@ include file="navigationmenu_shipowner.jsp"%>

	<% UserLogin user = (UserLogin)session.getAttribute("user-object"); %>

    <header class="header-back text-black">
      <div class="container text-center">
        <h1><b>My profile</b></h1>

      </div>
    </header>
    
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<div class="center">
    <div class="container">
     <div class="card">
      <img src="images/member.png" style="width:100%">
      <h3><%=user.getEmail()%> <%=user.getName()%></h3>
      <p class="title">Shipowner</p>
      <p>FindCrew Member</p>
      <div style="margin: 24px 0;">
        <a href="#"><i class="fa fa-dribbble"></i></a> 
        <a href="#"><i class="fa fa-twitter"></i></a>  
        <a href="#"><i class="fa fa-linkedin"></i></a>  
        <a href="#"><i class="fa fa-facebook"></i></a> 
      </div>
      <p><button>Contact</button></p>
    </div>




  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
