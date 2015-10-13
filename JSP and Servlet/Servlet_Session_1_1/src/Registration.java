import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		PrintWriter print = responce.getWriter();
		boolean isValid = true;
		responce.setContentType("text/html");
		print.println("This is servlet<br>");
		if(request.getParameter("fname") == "") {
			print.print("First Name can't be empty<br>");
			isValid = false;
		}
		if(request.getParameter("lname") == "") {
			print.print("Last Name can't be empty<br>");
			isValid = false;
		}
		if(request.getParameter("pass") == "" || request.getParameter("pass").length() < 8 ) {
			print.print("Pass must be 8 character long<br>");
			isValid = false;
		}
		if(request.getParameter("repass") == "") {
			print.print("Re-Enter password can't be null<br>");
			isValid = false;
		}
		if(!request.getParameter("pass").equalsIgnoreCase(request.getParameter("repass"))) 
		{  
			print.println("Password doesn't match<br>");
			isValid=false;
		}
		if(request.getParameter("age") == "") {
			print.print("age can't be empty<br>");
			isValid = false;
		}
		if(request.getParameter("state").equalsIgnoreCase("Select State")) {
			print.print("Select a valid state<br>");
			isValid = false;
		}
		if(request.getParameter("city").equalsIgnoreCase("Select City")) {
			print.print("Select a valid city<br>");
			isValid = false;
		}
		if(isValid == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, responce);
		}
	}
}