package edu.csula.cs3220.hw03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menu/add")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		
		FoodItem addItem = null;
		
		for(FoodItem food: foods){
			if(food.getId() == id) {
				addItem = food;
			}
		}
		
		
		List<FoodItem> newCustItems = (List<FoodItem>) getServletContext().getAttribute("newCustItems");
		getServletContext().setAttribute("newCustItems", newCustItems);

		PrintWriter out = response.getWriter();
		out.println("<h2> Item Added!</h2>");
		out.println("<button><a href='../menu'>Back To Menu</button>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
