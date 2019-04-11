package ca.sheridancollege.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.sendRedirect("form.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		List<User> users = null;
		DAO dao=new DAO();
		String butSelect=request.getParameter("button1");
		String fname=request.getParameter("fName");
		String lname=request.getParameter("lName");
		String userEmail=request.getParameter("email");
		String userPhone=request.getParameter("phone");
		
		String firstN=request.getParameter("firstName");
		String lastN=request.getParameter("lastName");

		if(butSelect.equals("Go!")) {
			if(fname.length()==0||lname.length()==0 || userEmail.length()==0|| userPhone.length()==0) {
				request.setAttribute("error", "Please provide in values");
			}
			else {

				User user=new User(fname,lname,userEmail,userPhone);	
				dao.insertUser(user);
				request.setAttribute("personList", dao.getUserList());
			}
		}
		else if (butSelect.equals("Search")) {
			users=dao.getUsersByName(firstN, lastN);
			if(users.isEmpty()) {
				String warningError="User not found! Please add user using form above.";
				request.setAttribute("error", warningError);
			}
			
			else {
				request.setAttribute("personList", users);
				request.setAttribute("error", "User found");
			}
		}

		//users= dao.getUsersByName(firstN, lastN);

		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
}
