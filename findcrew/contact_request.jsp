<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="ContactRequestJava.*"%>

   
<%
  if (session.getAttribute("user-object") == null) {
%>
<jsp:forward page = "login.jsp"/> 
<% } %>

<%
String crew_id  = request.getParameter("crew_id");


%>


<!DOCTYPE html>
<html lang="en">

  <head>

    <%@ include file="header.jsp"%>

    <!-- Custom styles for this template -->
    <link href="css/contact.css" rel="stylesheet">

  </head>

  <body>

    <%@ include file="navigationmenu_shipowner.jsp"%>
    
  <div class="container">
    <div class=" col-lg-12 col-md-12 col-sm-12">
      <div class="card">
        <img class="card-img-top" src="images/background.jpg" alt="Card image cap" style="width: width:100px;height:350px;">
        <div class="card-body" >
          <h3 class="card-title">Contact Request</h3>

          <form class="form-horizontal" name="form1" method="post" action="Contact_request_controller.jsp" >

            
                <label for="usr">Strating Period </label>
                <input type="text" class="form-control" id="start" required="textarea" name="start">

                <label for="usr">Ending Period </label>
                <input type="text" class="form-control" id="end" required="textarea" name="end">
          
                <label for="usr">Departure point</label>
                <input type="text" class="form-control" id="email" required="textarea" name="departure">
            
           
              <label for="comment">Description</label>
              <textarea class="form-control" rows="5" id="desc" required="textarea" name="description"></textarea>

              <input type="hidden" name="crew_id" value="<%=crew_id%>">

           <p> </p>
           <div class="form-group">
              <label class="checkbox-inline">
                 <input type="checkbox" name="checkbox" required="textarea" value="checkbox">I agree with the terms and conditions
              </label>  
          </div>

           
           <div class="container col-md-6">
           <button type="submit" name="submit" class="btn btn-primary btn-block">Send</button> 
           </div> 

         </form> 

       </div>
      </div>
    </div>
  </div>

  

  <%@ include file = "footer.jsp" %>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
