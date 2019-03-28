// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import exercise3_2018_2019_8150088.*;

/* Extend HttpServlet class
*author @mariabartza 81550088

*/
public class RegisterController_ex3_8150088 extends HttpServlet {

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = new PrintWriter(response.getWriter(), true);

    //get user's data from request
    String registrationName = request.getParameter("inputName");
    String registrationSurname = request.getParameter("inputSurname");
    String registrationEmail = request.getParameter("inputEmail");
    String registrationUsername = request.getParameter("inputUsername");
    String registrationPassword = request.getParameter("inputPassword");
    String registrationConfirm = request.getParameter("inputConfirmPassword");
    String registrationAgreeTerms = request.getParameter("agreeTerms");

	try {
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("	<head>");
		out.println("		<meta charset='utf-8'>");
		out.println("		<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		out.println("		<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->");
		out.println("		<meta name='description' content='Lab exercise template 2018-2019'>");
		out.println("		<meta name='author' content='sofos@aueb.gr'>");
		out.println("		<link rel='icon' href='../images/favicon.ico'>");
		out.println("");
		out.println("		<title>3η ατομική Άσκηση</title>");
		out.println("");
		out.println("		<!-- Bootstrap core CSS -->");
		out.println("		<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.println("		<!-- Bootstrap Optional theme -->");
		out.println("		<link rel='stylesheet' href='../css/bootstrap-theme.min.css'>");
		out.println("		<!-- Custom styles for this template -->");
		out.println("		<link href='../css/theme_8150088.css'; rel='stylesheet'>");
		out.println("		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->");
		out.println("		<!--[if lt IE 9]>");
		out.println("			<script src='https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js'></script>");
		out.println("			<script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script>");
		out.println("		<![endif]-->");
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
		out.println("					<a class='navbar-brand' href='#'>8150088</a>");
		out.println("				</div>");
		out.println("				<div id='navbar' class='navbar-collapse collapse'>");
		out.println("					<ul class='nav navbar-nav'>");
		//ex3
		out.println("						<li><a href='../index_ex3_8150088.jsp'>Home</a></li>");
		out.println("						<li><a href='../about_ex3_8150088.jsp'>About</a></li>");
		//
		out.println("					</ul>");
		//ex3
		out.println(" 					<ul class='nav navbar-nav navbar-right'>");
		out.println("						<li class='active'><a href='../register_ex3_8150088.jsp'>Register</a></li>");
		out.println("						<li><a href='../login_ex3_8150088.jsp'>Sign in</a></li>");
		out.println("					</ul>");
		//
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
		out.println("				<h1>3η Ατομική Άσκηση</h1>");
		out.println("			</div>");
		out.println("");

		//ex3
		UserDAO usrd = new UserDAO();
		//

		if (registrationAgreeTerms == null){
			out.println("		<div class='page-header'>");
			out.println("			<h1>Registration Failed!</h1>");
			out.println("		</div>");

			out.println("		<div class='alert alert-danger' role='alert'>");
			out.println("			Sorry, you must agree to the terms and conditions in order to register!");
			out.println("		</div>");
		//ex3
		} else if ((registrationName.length()>=3) & (registrationSurname.length()>=3) & (registrationUsername.length()>=5) & (registrationPassword.length()>=5) & (registrationPassword.equals(registrationConfirm)) & (usrd.findUser(registrationUsername)==null) ) {
			User us = new User(registrationName, registrationSurname, registrationEmail, registrationUsername, registrationPassword);
			usrd.registerUser(us);
		//
			out.println("		<div class='page-header'>");
			out.println("			<h1>Registration almost done!</h1>");
			out.println("		</div>");

			out.println("		<div class='alert alert-warning'>");
			out.println("			<strong>Note:</strong> A verification link has been send to the email:" + registrationEmail);
			out.println("		</div>");

			out.println("		<b>Name: </b>" + registrationName + "<br>");
			out.println("		<b>Surname: </b>" + registrationSurname + "<br>");
			out.println("		<b>Username: </b>" + registrationUsername + "<br>");
			out.println("		<b>Email: </b>" + registrationEmail + "<br>");
		} else {
			out.println("		<div class='page-header'>");
			out.println("			<h1>Registration Form errors</h1>");
			out.println("		</div>");

			out.println("		<div class='alert alert-danger' role='alert'>");
			out.println("			<ol type='1'>");
			if (registrationName.length()< 3){
				out.println("			<li>Name must me at least 3 characters long</li>");
			}
			if (registrationSurname.length()< 3){
				out.println("			<li>Surname must me at least 3 characters long</li>");
			}
			if (registrationUsername.length()< 5){
				out.println("			<li>Username must me at least 5 characters long</li>");
			}
			if (registrationPassword.length()< 5){
				out.println("			<li>Password must me at least 5 characters long</li>");
			}
			if (!registrationPassword.equals(registrationConfirm)){
				out.println("			<li>The password and corfirmation password must be the same</li>");
			}

			//ex3
			if (usrd.findUser(registrationUsername)!= null){
				out.println("			<li>Username <b>" + registrationUsername + "</b> already exists!</li>");
			}
			//

			out.println("			</ol>");
			out.println("		</div>");

			out.println("		<div align= 'center'>");
			out.println("			<a class='btn btn-info' href='../register_ex3_8150088.jsp' role='button'> <b><</b> Back to the form</a>");
			out.println("		</div>");
		}

			out.println("</div>");
			out.println("		<!-- /container -->");
			out.println("");

			//ex3
			RequestDispatcher rd = request.getRequestDispatcher("../footer_ex3_8150088.jsp");
			rd.include(request, response);
/*
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
			out.println("		<script src='../js/jquery.min.js'></script>");
			out.println("		<!-- Bootstrap core JavaScript -->");
			out.println("		<script	src='../js/bootstrap.min.js'></script>");
*/
			out.println("	</body>");
			out.println("</html>");



	} catch (Exception ex) {
		out.println("Exception: " + ex.getMessage());
		out.println("</body>");
		out.println("</html>");
	}

  } // End of doPost

  // Method to handle GET method request.
     public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		response.sendRedirect("http://ism.dmst.aueb.gr/ismgroup20/register_ex3_8150088.jsp");
        //doPost(request, response);
   } //End of doGet

}// End of class