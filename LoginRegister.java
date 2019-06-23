package login.submit.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginRegister() {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); //Check this
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");
		 
		CustomerImplementation cImplementation = new CustomerImplementation();
		Customer c = cImplementation.getCustomer(name, username, password);
	
		if(submitType.equals("login") && c != null && c.getName() != null) {
			
			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
			
		} else if(submitType.equals("register")){
			
			c.setName(request.getParameter("name"));
			c.setPassword(password);
			c.setUsername(username);
			cImplementation.insertCustomer(c);
			
			request.setAttribute("message2", "Thanks for registering. You may now log in.");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			
		} else {
			request.setAttribute("message", "User not found. Please register before attemping to log in.");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
	}

}
