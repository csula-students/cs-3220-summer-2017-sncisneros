package edu.csula.cs3220.lab03;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;


@WebServlet(loadOnStartup = 1, urlPatterns={"/admin/foods/create/"})
public class CreateFoodAdminServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public CreateFoodAdminServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		//create a form for client to fill
		out.println("<form method=\"post\">");
		out.println("Food Name: <input name='name' type='text' /></br>");
		out.println("Food Description: <textarea name='description'></textarea></br>");
		out.println("Image URL: <input name='imageUrl' type='text' /></br>");
		out.println("Food Price: <input name='price' type='text' /></br>");
		out.println("<button>Add</button>");
		out.println("</form>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		foods.add(new FoodItem(foods.size(), request.getParameter("name"), request.getParameter("description"), request.getParameter("imageUrl"), Double.parseDouble(request.getParameter("price"))));
		
		getServletContext().setAttribute("foods", foods);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='/admin/foods/'>Back To Food List</a>");

	}

}
