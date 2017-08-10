package edu.csula.cs3220.hw03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.hw03.Order.statuses;


@WebServlet(loadOnStartup = 1, urlPatterns={"/menu"})
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FoodMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        /*
         * foods.add(new FoodItem(foods.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
		foods.add(new FoodItem(foods.size(), "Tacos", "Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa!", "http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg", 17.95));
		foods.add(new FoodItem(foods.size(), "Buffalo Wings", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch!", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", 15.95));
		
         */
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
				
		
		request.getRequestDispatcher("/index.jsp")
        .forward(request, response);
		
		int id = Integer.parseInt(request.getParameter("add"));
		
		FoodItem addItem = null;
		
		for(FoodItem food: foods){
			if(food.getId() == id) {
				addItem = food;
			}
		}
		
		List<FoodItem> newCustItems = new ArrayList<>();
		newCustItems.add(new FoodItem(newCustItems.size(), addItem.getName(), addItem.getDescription(), addItem.getImageUrl(), addItem.getPrice()));
		
		getServletContext().setAttribute("newCustItems", newCustItems);
		
		 response.sendRedirect("../shopping-cart");
		//request.getRequestDispatcher("/order.jsp")
       // .forward(request, response);
		
			
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
