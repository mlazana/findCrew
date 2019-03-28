package exercise3_2018_2019_8160057;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterController_8160057 extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

         response.setContentType("text/html; charset=ISO-8859-7");
         PrintWriter out = new PrintWriter(response.getWriter(), true);

         String name = request.getParameter("nameField");
         String surname = request.getParameter("surname");
         String username = request.getParameter("username");
         String password = request.getParameter("pwd");
         String confirm = request.getParameter("confirm");
         String email = request.getParameter("email");
         String submit[] = request.getParameterValues("submit");
         String checkbox = request.getParameter("checkbox");

         try {

              out.println("<!DOCTYPE html>");
			  out.println("<html lang='en'>");
			  out.println("	<head>");
			  out.println("	<meta charset='utf-8'>");
			  out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			  out.println("	<meta name='viewport' content='width=device-width, initial-scale=1'>");
			  out.println("	<meta name='description' content='Lab exercise template 2018-2019'>");
			  out.println("	<meta name='author' content='sofos@aueb.gr'>");
			  out.println("	<link rel='icon' href='images/favicon.ico'>");
			  out.println("	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			  out.println("	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
			  out.println("	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
			  out.println("");
			  out.println("	<title>About</title>");
			  out.println("	<link rel='stylesheet' href='../css/bootstrap.min.css'>");
			  out.println("	<link rel='stylesheet' href='../css/bootstrap-theme.min.css'>");
			  out.println("	<link href='../css/theme_8160057.css' rel='stylesheet'>");
			  out.println("	</head>");
			  out.println("");
			  out.println("	<body>");
			  out.println("");
			  out.println("		<nav class='navbar navbar-inverse navbar-fixed-top'>");
			  out.println("			<div class='container'>");
			  out.println("				<div class='navbar-header'>");
			  out.println("					<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'>");
			  out.println("						<span class='sr-only'>Toggle navigation</span>");
			  out.println("						<span class='icon-bar'></span> <span class='icon-bar'></span>");
			  out.println("						<span class='icon-bar'></span>");
			  out.println("					</button>");
			  out.println("					<a class='navbar-brand' href='#'>8160057</a>");
			  out.println("				</div>");
			  out.println("				<div id='navbar' class='navbar-collapse collapse'>");
			  out.println("					<ul class='nav navbar-nav'>");
			  out.println("						<li ><a href='http://ism.dmst.aueb.gr/ismgroup20/index_8160057.html'>Home</a></li>");
			  out.println("						<li class='active'><a href='http://ism.dmst.aueb.gr/ismgroup20/register_8160057.html'>Register</a></li>					");
			  out.println("						<li><a href='http://ism.dmst.aueb.gr/ismgroup20/about_8160057.html'>About</a></li>	");
			  out.println("					</ul>");
			  out.println("");
			  out.println("				</div>");
			  out.println("			</div>");
			  out.println("		</nav>");
			  out.println("");
			  out.println("		<div class='container theme-showcase' role='main'>");
			  out.println("			<div class='jumbotron'>");
			  out.println("				<h1>1st individual excercise</h1>");
			  out.println("			</div>");

             UserDAO udao = new UserDAO();



            if (checkbox == null){

			out.println("			<div class='page-header'>");
			out.println("				<h1>Registration failed!</h1>");
			out.println("            </div>	");
			out.println("");
			out.println("		<div class='alert alert-danger' role='alert'>");
			out.println("           Sorry,you must agree to terms and conditions in order to register!");
			out.println("       </div>	");

			}


         else if ((name.length() >= 3) && (surname.length() >= 3) && (username.length() >= 5) &&
              (password.length() >=5) && (password.equals(confirm))  ) {


				  out.println("			<div class='page-header'>");
				  out.println("				<h1>Registration almost done!</h1>");
				  out.println("            </div>	");
				  out.println("");
				  out.println("		    ");
				  out.println("			<div class='alert alert-warning' role='alert'>");
				  out.println("           <strong>Note:</strong> A verification link has been send to email: jdoe76@example.com");
				  out.println("			</div>");
				  out.println("");
				  out.println("			<div><strong>");
				  out.println("				<p>Name: </strong>"+ name + "</p>");
				  out.println("				<strong><p>Surname: </strong>" + surname + "</p>");
				  out.println("				<strong><p>Username:</strong>" + username + "</p>");
				  out.println("				<strong><p>Email:</strong>" + email + "</p>");
				  out.println("			</div>");



           }else{
			  out.println("	<div class='page-header'>");
			  out.println("				<h1>Registration Form errors</h1>");
			  out.println("		</div>    ");
              out.println(" <div class='alert alert-danger' role='alert'>");
              int s=1;
			  if (name.length()< 3){out.println ("<p>" + s + ".Name must be at least 3 characters long </p>");
			                        s=s+1;}
			  if (surname.length() < 3){out.println ("<p>" + s + ".Surame must be at least 3 characters long </p>");
			                           s=s+1;}
			  if (username.length() < 5){out.println ("<p>" + s + ".Userame must be at least 5 characters long</p>");
			                            s=s+1;}
			  if (password.length() < 5){out.println ("<p>" + s + ".Password must be at least 5 characters long</p>");
			                            s=s+1;}
			  if (password.equals(confirm)){out.println ("<p>" + s + ".Password and confirmation must be equal</p>"); }



			out.println(" </div>");
			out.println(" <div class='wrapper'>");
			out.println("<a href='http://ism.dmst.aueb.gr/ismgroup20/register_8160057.html' class='btn btn-info' role='button'><span class='glyphicon glyphicon-chevron-left' aria-hidden='true'></span>Back to the form</a>");
			out.println(" </div>");

			}


			/* Footer */
			out.println("</div>");
			out.println("		<footer class='navbar-inverse'>");
			out.println("			<div class='container'>");
			out.println("				<div class='row'>");
			out.println("					<div class='col-xs-12'>");
			out.println("						<p class='text-center'>&copy; Copyright 2018 by ismgroup20</p>");
			out.println("					</div>");
			out.println("				</div>");
			out.println("			</div>");
			out.println("		</footer>");
			out.println("");
			out.println("		<script src='js/jquery.min.js'></script>");
			out.println("		<script	src='js/bootstrap.min.js'></script>");
			out.println("	</body>");
			out.println("</html>");






          } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            out.println("</body>");
            out.println("</html>"); }

     }

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	 		response.setContentType("text/html; charset=UTF-8");
	     	PrintWriter out = new PrintWriter(response.getWriter(), true);

	     	try {
	 			out.println("<!DOCTYPE html>");
				out.println("<html lang='en'>");
				out.println("	<head>");
				out.println("	<meta charset='utf-8'>");
				out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
				out.println("	<meta name='viewport' content='width=device-width, initial-scale=1'>");
				out.println("	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->");
				out.println("	<meta name='description' content='Lab exercise template 2018-2019'>");
				out.println("	<meta name='author' content='sofos@aueb.gr'>");
				out.println("	<link rel='icon' href='images/favicon.ico'>");
				out.println("	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
				out.println("	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
				out.println("	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
				out.println("");
				out.println("	<title>Register</title>");
				out.println("");
				out.println("	<!-- Bootstrap core CSS -->");
				out.println("	<link rel='stylesheet' href='css/bootstrap.min.css'>");
				out.println("	<!-- Bootstrap Optional theme -->");
				out.println("	<link rel='stylesheet' href='css/bootstrap-theme.min.css'>");
				out.println("	<!-- Custom styles for this template -->");
				out.println("	<link href='css/theme_8160057.css' rel='stylesheet'>");
				out.println("	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->");
				out.println("	<!--[if lt IE 9]>");
				out.println("		  <script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script>");
				out.println("		  <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script>");
				out.println("	<![endif]-->");
				out.println("	</head>");
				out.println("");
				out.println("	<body>");
				out.println("");
				out.println("		<!-- Fixed navbar -->");
				out.println("		<nav class='navbar navbar-inverse navbar-fixed-top'>");
				out.println("			<div class='container'>");
				out.println("				<div class='navbar-header'>");
				out.println("					<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'>");
				out.println("  						<span class='sr-only'>Toggle navigation</span>");
				out.println("						<span class='icon-bar'></span> <span class='icon-bar'></span>");
				out.println("						<span class='icon-bar'></span>");
				out.println("					</button>");
				out.println("					<a class='navbar-brand' href='#'>8160057</a>");
				out.println("				</div>");
				out.println("				<div id='navbar' class='navbar-collapse collapse'>");
				out.println("					<ul class='nav navbar-nav'>");
				out.println("						<li><a href='http://ism.dmst.aueb.gr/ismgroup20/index_8160057.html'>Home</a></li>");
				out.println("						<li class='active'><a href='http://ism.dmst.aueb.gr/ismgroup20/register_8160057.html'>Register</a></li>					");
				out.println("						<li><a href='http://ism.dmst.aueb.gr/ismgroup20/about_8160057.html'>About</a></li>");
				out.println("					</ul>");
				out.println("");
				out.println("				</div>");
				out.println("				<!--/.nav-collapse -->");
				out.println("			</div>");
				out.println("		</nav>");
				out.println("");
				out.println("		<div class='container theme-showcase' role='main'>");
				out.println("");
				out.println("			<!-- Main jumbotron for a primary marketing message or call to action -->");
				out.println("			<div class='jumbotron'>");
				out.println("				<h1>1� ������� ������</h1>");
				out.println("			</div>");
				out.println("			<!-- Page Title -->");
				out.println("			<div class='alert alert-warning text-center'>");
				out.println("				<strong>Please fill in the following form to create an account</strong>");
				out.println("			</div>");
				out.println("			");
				out.println("			<div class='page-header'>");
				out.println("				<h1>Registration Form </h1>");
				out.println("			</div>");
				out.println("			<div class='col-md-7 col-md-offset-1'>");
				out.println("					<form class='form-horizontal' name='form1' action='servlet/RegisterController_8160057'");
				out.println("					 method='POST' >");
				out.println("						<div class='form-group'>");
				out.println("						  <label class='control-label col-sm-2' for='name'>Name</label>");
				out.println("						  <div class='col-sm-10'>");
				out.println("							<input type='text' class='form-control' id='name' placeholder='your name' name='nameField'>");
				out.println("						  </div>");
				out.println("						</div>");
				out.println("						<div class='form-group'>");
				out.println("						  <label class='control-label col-sm-2' for='surname'>Surname</label>");
				out.println("						  <div class='col-sm-10'>          ");
				out.println("							<input type='text' class='form-control' id='surname' placeholder='your surname' name='surname'>");
				out.println("						  </div>");
				out.println("						</div>");
				out.println("						<div class='form-group'>");
				out.println("								<label class='control-label col-sm-2' for='username'>Username</label>");
				out.println("								<div class='col-sm-10'>          ");
				out.println("								  <input type='text' class='form-control' id='username' placeholder='your username' name='username'>");
				out.println("								</div>");
				out.println("							  </div>");
				out.println("					    <div class='form-group'>");
				out.println("								<label class='control-label col-sm-2' for='username'>Email</label>");
				out.println("								<div class='col-sm-10'>          ");
				out.println("								  <input type='text' class='form-control' id='email' placeholder='your email' name='email'>");
				out.println("								</div>");
				out.println("							  </div>");
				out.println("");
				out.println("						<div class='form-group'>");
				out.println("							<label class='control-label col-sm-2' for='pwd'>Password</label>");
				out.println("							<div class='col-sm-10'>          ");
				out.println("								<input type='password' class='form-control' id='pwd' placeholder='your password' name='pwd'>");
				out.println("							</div>");
				out.println("						</div>");
				out.println("						<div class='form-group'>");
				out.println("								<label class='control-label col-sm-2' for='confirm'>Confirm</label>");
				out.println("								<div class='col-sm-10'>          ");
				out.println("									<input type='password' class='form-control' id='confirm' placeholder='Confirm your password' name='confirm'>");
				out.println("								</div>");
				out.println("						</div>");
				out.println("                        ");
				out.println("						<div class='col-md-6 col-md-offset-2'>");
				out.println("							");
				out.println("							<div class='form-group'>");
				out.println("									<label class='checkbox-inline'>");
				out.println("											<input type='checkbox' name='checkbox'value='checkbox'>I agree with the terms and conditions");
				out.println("									</label>	");
				out.println("							</div>");
				out.println("");
				out.println("							");
				out.println("						<button class='btn btn-success' type='submit' name='submit'><span class='glyphicon glyphicon-ok' aria-hidden='true'></span> Submit  ");
				out.println("						</button>");
				out.println("						<button type='button' class='btn btn-danger' data-dismiss='modal' name='cancel' ><span class='glyphicon glyphicon-remove' aria-hidden='true'></span> Cancel</button>");
				out.println("									");
				out.println("					</div>	");
				out.println("					</form>");
				out.println("			</div>");
				out.println("</div>");
				out.println("		<!-- /container -->");
				out.println("");
				out.println("		<!-- footer -->");
				out.println("		<footer class='navbar-inverse'>");
				out.println("			<div class='container'>");
				out.println("				<div class='row'>");
				out.println("					<div class='col-xs-12'>");
				out.println("						<p class='text-center'>&copy; Copyright 2018 by ismgroup20</p>");
				out.println("					</div>");
				out.println("				</div>");
				out.println("			</div>");
				out.println("");
				out.println("		</footer>");
				out.println("		<!-- End footer -->");
				out.println("");
				out.println("		<!-- =================== Place all javascript at the end of the document so the pages load faster =================== -->");
				out.println("		<!-- jQuery library -->");
				out.println("		<script src='js/jquery.min.js'></script>");
				out.println("		<!-- Bootstrap core JavaScript -->");
				out.println("		<script	src='js/bootstrap.min.js'></script>");
				out.println("	</body>");
				out.println("</html>");

	 } catch (Exception ex) {
	             out.println("Exception: " + ex.getMessage());
	             out.println("</body>");
	             out.println("</html>");
	           }




 }

 }