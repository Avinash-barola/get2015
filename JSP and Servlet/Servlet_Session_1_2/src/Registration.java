import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		boolean isValid = true;
		String result = "";
		responce.setContentType("text/html");
		result += "This is servlet<br>";
		if(request.getParameter("fname") == "") {
			result += "First Name can't be empty<br>";
			isValid = false;
		}
		if(request.getParameter("lname") == "") {
			result += "Last Name can't be empty<br>";
			isValid = false;
		}
		if(request.getParameter("pass") == "" || request.getParameter("pass").length() < 8 ) {
			result += "Pass must be 8 character long<br>";
			isValid = false;
		}
		if(request.getParameter("repass") == "") {
			result += "Re-Enter password can't be null<br>";
			isValid = false;
		}
		if(!request.getParameter("pass").equalsIgnoreCase(request.getParameter("repass"))) 
		{  
			result += "Password doesn't match<br>";
			isValid=false;
		}
		if(request.getParameter("age") == "") {
			result += "age can't be empty<br>";
			isValid = false;
		}
		if(request.getParameter("state").equalsIgnoreCase("Select State")) {
			result += "Select a valid state<br>";
			isValid = false;
		}
		if(request.getParameter("city").equalsIgnoreCase("Select City")) {
			result += "Select a valid city<br>";
			isValid = false;
		}
		if(isValid == true) {
			result += "Form Validated<br>";
			
		}
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("Validation");
		rd.forward(request, responce);
	}
}