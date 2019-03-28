<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="FavouritesJava.*" %>
<%@ page import="FindCrewJava.*" %>
<%@ page import="LoginJava.*" %>
<%@ page errorPage="error_page.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.Set" %>

<%
  if (session.getAttribute("user-object") == null) {
%>
<jsp:forward page = "login.jsp"/> 
<% } %>


<%

UserLogin usr = (UserLogin)session.getAttribute("user-object");
UserLoginDAO udao = new UserLoginDAO();

int userid = usr.getID();
int sid = udao.getShipownerId(userid);

FavouritesDAO  favourites = new FavouritesDAO();

if(request.getParameter("crew_id") != null){
String cid = request.getParameter("crew_id");
favourites.addFavourite(sid,cid);
}

List<Crew> crews = favourites.getFavourites(sid);

 

%>


<!DOCTYPE html>
<html lang="en">

  <head>
	<%@ include file="header.jsp"%>
    <link href="css/favorites.css" rel="stylesheet">
  </head>

  <body id="page-top">

	<%@ include file="navigationmenu_shipowner.jsp"%>

  <header class="header-back text-white">
  <div class="container text-center" style="color:black; ">

    <h1><b>Saved profiles</b></h1>
    <p class="lead"><b>manage your crew!</b></p>
    <% if (crews.size() == 0){
    %><p><h2>Sorry, you haven't any favourite crew yet. </h2></p>
    <%
     }
    %>
  </div>
  <hr>
  </header>

   <div class="container">
     <div class="row justify-content-center">
       <div class="col-lg-6 col-xl-6 col-xs-12 col-sm-12 col-md-12">
       	    
	          <% for (Crew crew : crews) {%>
	          <div class="card my-4" id="profil">
	            <div class="row">
	              <div class="col-sm-3" align="right">
	                <img class="card-img-top" src="images/<%=crew.getImage_file() %>" alt="Card image cap">
	              </div>
	              <div class="col-sm-9">
	                <h5><%=crew.getName() %> <%=crew.getSurname() %></h5>
	                <p>
	                  <b>Profession:</b> 
	                  <%=crew.getProfession() %>
	                  <br> 
	                  <b>Country:</b> 
	                  <%=crew.getCountry() %>
	                  <br> 
	                  <b>Gender:</b> 
	                  <%=crew.getGender() %>
	                  <br>
	                  <b>Available from:</b> 
	                  <%=crew.getAvailability() %>
	                  <div class="text-right">
	                    <a href="individual.jsp?idcrew=<%=crew.getIdcrew() %>"><button type="button" class="btn btn-primary btn">View Profile</button></a>
	                  </div>
	                </p>
	              </div>
	            </div>
	          </div>
	          <% } %>
          <!-- /.row -->
          

        </div>

        
     </div>
    </div>



<!-- =================== Place all javascript at the end of the document so the pages load faster =================== -->
<!-- jQuery library -->
<script src="vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/scrolling-nav.js"></script>

  </body>

</html>
