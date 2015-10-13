import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		responce.setContentType("text/html");
		PrintWriter print = responce.getWriter();
		print.print(request.getAttribute("result"));
	}
}