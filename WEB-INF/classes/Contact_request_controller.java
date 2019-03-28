
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class Contact_request_controller extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

         response.setContentType("text/html; charset=ISO-8859-7");
         PrintWriter out = new PrintWriter(response.getWriter(), true);

         String username = request.getParameter("username");
         String period = request.getParameter("period");
         String departure = request.getParameter("departure");
         String description = request.getParameter("description");
         String submit[] = request.getParameterValues("submit");
         String checkbox = request.getParameter("checkbox");


         try{

         	                 out.println("<!DOCTYPE html>");
							 out.println("<html lang='en'>");
							 out.println("");
							 out.println("  <head>");
							 out.println("");
							 out.println("    <meta charset='utf-8'>");
							 out.println("    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
							 out.println("    <meta name='description' content=''>");
							 out.println("    <meta name='author' content=''>");
							 out.println("");
							 out.println("    <title>FindCrew</title>");
							 out.println("");
							 out.println("    <!-- Bootstrap core CSS -->");
							 out.println("    <link href='../FindCrew/vendor/bootstrap/css/bootstrap.min.css' rel='stylesheet'>");
							 out.println("");
							 out.println("    <!-- Custom styles for this template -->");
							 out.println("    <link href='../FindCrew/css/mainpage.css' rel='stylesheet'>");
							 out.println("");
							 out.println("    <!-- Custom style for main html -->");
							 out.println("    <link href='../FindCrew/css/main_css.css' rel='stylesheet'>");
							 out.println("");



							 out.println("");
							 out.println("");
							 out.println("    ");
							 out.println("");
							 out.println("  </head>");
							 out.println("");
							 out.println("  <body id='page-top'>");
							 out.println("");
							 out.println("    <!-- Navigation -->");
							 out.println("    <nav class='navbar navbar-expand-lg navbar-light bg-light fixed-top' id='mainNav'>");
							 out.println("      <div class='container'>");
							 out.println("        <a class='navbar-brand js-scroll-trigger' href='index.jsp'><img style='max-width:110px; margin-top: -4px;' src='../FindCrew/images/l.png '></a>");
							 out.println("        ");
							 out.println("        <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarResponsive' aria-controls='navbarResponsive' aria-expanded='false' aria-label='Toggle navigation'>");
							 out.println("          <span class='navbar-toggler-icon'></span>");
							 out.println("        </button>");
							 out.println("        <div class='collapse navbar-collapse' id='navbarResponsive'>");
							 out.println("          <ul class='navbar-nav ml-auto'>");
							 out.println("            <li class='nav-item dropdown'>              ");
							 out.println("                <a class='nav-link dropdown-toggle' id='navbarDropdownPortfolio' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false' href='#'>About</a>");
							 out.println("                <div class='dropdown-menu dropdown-menu-right' aria-labelledby='navbarDropdownPortfolio'>");
							 out.println("                  <a href='#about' class='dropdown-item'>About Us</a>");
							 out.println("                  <a href='#services' class='dropdown-item'>Services</a>");
							 out.println("                  <a href='#team' class='dropdown-item'>Team</a>");
							 out.println("                </div>");
							 out.println("            </li>");
							 out.println("            <li class='nav-item'>");
							 out.println("              <a class='nav-link' href='profiles.jsp'>Crew</a>");
							 out.println("            </li>");
							 out.println("            <li class='nav-item'>");
							 out.println("              <a class='nav-link js-scroll-trigger' href='#contact'>Contact</a>");
							 out.println("            </li>");
							 out.println("            <li class='nav-item'>");
							 out.println("              <a class='nav-link js-scroll-trigger' href='login.jsp'>Login</a>");
							 out.println("            </li>");
							 out.println("          </ul>");
							 out.println("        </div>");
							 out.println("      </div>");
							 out.println("    </nav>");
							 out.println("");
                             out.println("		<div class='container theme-showcase' role='main'>");
							 out.println("				<h1>1st individual excercise</h1>");
			                 out.println("			</div>");







			out.println("");
			out.println("		<script src='../FindCrew/js/jquery.min.js'></script>");
			out.println("		<script	src='../FindCrew/js/bootstrap.min.js'></script>");
			out.println("	</body>");
			out.println("</html>");


        } catch (Exception ex) {
            out.println("Exception: " + ex.getMessage());
            out.println("</body>");
            out.println("</html>"); }

   }
}