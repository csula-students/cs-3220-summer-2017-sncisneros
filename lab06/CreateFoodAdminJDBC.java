package edu.csula.cs3220.lab06;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;


@WebServlet(loadOnStartup = 1, urlPatterns={"/lab06/admin/foods/create/"})
public class CreateFoodAdminJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public CreateFoodAdminJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jdbc/createfoodjdbc.jsp")
        .forward(request, response);
		/*response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		//create a form for client to fill
		out.println("<form method=\"post\">");
		out.println("Food Name: <input name='name' type='text' /></br>");
		out.println("Food Description: <textarea name='description'></textarea></br>");
		out.println("Image URL: <input name='imageUrl' type='text' /></br>");
		out.println("Food Price: <input name='price' type='text' /></br>");
		out.println("<button>Add</button>");
		out.println("</form>");
		*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
			String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        String imageUrl = request.getParameter("url");
	        Double price = Double.parseDouble(request.getParameter("price"));
	        FoodItem newEntry = new FoodItem(-1, name, description, imageUrl, price);

	        FoodItemDAO dao = new FoodItemDAO();
	        dao.add(newEntry);
	        response.sendRedirect("../foods");
		
	}

}
