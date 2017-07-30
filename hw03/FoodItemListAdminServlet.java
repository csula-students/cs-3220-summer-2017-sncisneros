package edu.csula.cs3220.hw03;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;


@WebServlet(loadOnStartup = 1, urlPatterns={"/admin/foods/"})
public class FoodItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init(){
		List<FoodItem> foods = new ArrayList<>();
		
		foods.add(new FoodItem(foods.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
		foods.add(new FoodItem(foods.size(), "Tacos", "Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa.!", "http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg", 17.95));
		foods.add(new FoodItem(foods.size(), "Wings", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch!", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", 15.95));
		getServletContext().setAttribute("foods", foods);
		
	}
	
    public FoodItemListAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		
		request.getRequestDispatcher("/inventory.jsp")
        .forward(request, response);
		//response.setContentType("text/html");
		
		/*out.println("<table>");
		for (FoodItem food: foods){
			
			out.println("<tr>" +
					"<td>" + food.getName() + " : </td>" +
					"<td><img src ='" + food.getImageUrl() + "' alt='image' style='width:50px;height:50px' /></td>" +
					"<td>" + food.getDescription() + "</td>" +
					"<td>" + food.getPrice() + "</td>" +
					"<td><a href='/admin/foods/edit?id=" + food.getId() + "'>Edit </a> " +					
					"</tr>");
		}
		out.println("</table>");
		out.println("<a href='create/'>Add Food Item</a>");
		*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
