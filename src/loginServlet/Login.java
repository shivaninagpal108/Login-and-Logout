package loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(name.equals("Shivani") && password.equals("shanu108"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",name);
			response.sendRedirect("WelcomeUser.jsp");
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("Wrong username and passoword entered.");
		}
	}
}
