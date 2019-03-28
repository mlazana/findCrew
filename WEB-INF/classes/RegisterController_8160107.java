import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RegisterController_8160107 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  new PrintWriter(response.getWriter(), true);

		String name = request.getParameter("nameField");
		String surname = request.getParameter("surnameField");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String checkbox = request.getParameter("checkbox");
		String submit = request.getParameter("submit");                                

		/* General try */
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html lang='en'>");
			out.println("	<head>");
			out.println("	<meta charset='UTF-8'>");
			out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			out.println("	<meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.println("	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->");
			out.println("	<meta name='description' content='Lab exercise template 2018-2019'>");
			out.println("	<meta name='author' content='sofos@aueb.gr'>");
			out.println("	<link rel='icon' href='images/favicon.ico'>");
			out.println("");
			out.println("	<title>1st Individual Exercise</title>");
			out.println("");
			out.println("	<!-- Bootstrap core CSS -->");
			out.println("	<link rel='stylesheet' href='http://ism.dmst.aueb.gr/ismgroup20/css/bootstrap.min.css'>");
			out.println("	<!-- Bootstrap Optional theme -->");
			out.println("	<link rel='stylesheet' href='http://ism.dmst.aueb.gr/ismgroup20/css/bootstrap-theme.min.css'>");
			out.println("	<!-- Custom styles for this template -->");
			out.println("	<link href='http://ism.dmst.aueb.gr/ismgroup20/css/theme_8160107.css' rel='stylesheet'>");
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
			out.println("						<span class='sr-only'>Toggle navigation</span>");
			out.println("						<span class='icon-bar'></span> <span class='icon-bar'></span>");
			out.println("						<span class='icon-bar'></span>");
			out.println("					</button>");
			out.println("					<a class='navbar-brand' href='#'>8160107</a>");
			out.println("				</div>");
			out.println("				<div id='navbar' class='navbar-collapse collapse'>");
			out.println("					<ul class='nav navbar-nav'>");
			out.println("						<li><a href='http://ism.dmst.aueb.gr/ismgroup20/index_8160107.html'>Home</a></li>");
			out.println("						<li class='active'><a href='http://ism.dmst.aueb.gr/ismgroup20/register_8160107.html'>Register</a></li>");
			out.println("						<li><a href='http://ism.dmst.aueb.gr/ismgroup20/about_8160107.html'>About</a></li>");
			out.println("					</ul>");
			out.println("");
			out.println("				</div>");
			out.println("				<!--/.nav-collapse -->");
			out.println("			</div>");
			out.println("		</nav>");
			out.println("<div class='container theme-showcase' role='main'>");
			out.println("<!-- Main jumbotron for a primary marketing message or call to action -->");
			out.println(" <div class='jumbotron'>");
			out.println(" <meta charset='UTF-8'>  ");
			out.println("  <h1>1st Individual Exercise</h1>");
			out.println(" </div>");

			/* Checking the checkbox */
			if (checkbox==null) {
				out.println("<h1>Registration Failed!</h1>");
				out.println("<div class='alert alert-danger' role='alert'>");
				out.println("  Sorry, you must agree to the terms and conditions in ordfer to register!");
				out.println("</div>");	
			}

			/* Checking name, surname, username, password, corfirm */
			else if ((name.length() >= 3) && (surname.length() >= 3) && (username.length() >= 5) && (password.length() >=5) && (password.equals(confirm))) {
				out.println("<h1>Registration almost done!</h1>");
				out.println("<div class='alert alert-warning' role='alert'>");
				out.println("  <strong>Note:</strong> A verification link has been send to the email: " + email);
				out.println("</div>");
				out.println("<p><strong>Name: </strong>" + name + "</p>");
				out.println("<p><strong>Surname: </strong>" + surname + "</p>");
				out.println("<p><strong>Username: </strong>" + username + "</p>");
				out.println("<p><strong>Email: </strong>" + email + "</p>");
			} 	else {
				out.println("	<div class='page-header'>");
				out.println("				<h1>Registration Form errors</h1>");
				out.println("   </div>");
				out.println("");
				out.println(" <div class='alert alert-danger' role='alert'>");
				int k=1;
				  if (name.length()< 3){out.println ("<p>" + k + ".Name must be at least 3 characters long </p>");
										k=k+1;}
				  if (surname.length() < 3){out.println ("<p>" + k + ".Surame must be at least 3 characters long </p>");
										   k=k+1;}
				  if (username.length() < 5){out.println ("<p>" + k + ".Userame must be at least 5 characters long</p>");
											k=k+1;}
				  if (password.length() < 5){out.println ("<p>" + k + ".Password must be at least 5 characters long</p>");
											k=k+1;}
				  if (!(password.equals(confirm))){out.println ("<p>" + k + ".Password and confirmation must be equal</p>"); }
				out.println("</div>");
				out.println("<div class='wrapper'>");
				out.println("<a href='http://ism.dmst.aueb.gr/ismgroup20/register_8160107.html' class='btn btn-info' role='button'><span class='glyphicon glyphicon-chevron-left' aria-hidden='true'></span>Back to the form</a>");
				out.println("</div>");

			}





			/* Footer */
			out.println("</div>");
			out.println("<!-- footer -->");
			out.println("		<footer class='navbar-inverse'>");
			out.println("			<div class='container'>");
			out.println("				<div class='row'>");
			out.println("					<div class='col-xs-12'>");
			out.println("						<p class='text-center'>&copy; Copyright 2018 by ismgroup20</p>");
			out.println("					</div>");
			out.println("				</div>");
			out.println("			</div>");
			out.println("		</footer>");
			out.println("		<!-- End footer -->");
			out.println("		");
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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("http://ism.dmst.aueb.gr/ismgroup20/register_ex3_8160107.jsp");
		
	}


}
