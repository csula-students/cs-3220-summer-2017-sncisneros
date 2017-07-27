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


@WebServlet(loadOnStartup=1, urlPatterns= {"/shopping-cart"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		List<FoodItem> foods = new ArrayList<>();
		
		foods.add(new FoodItem(foods.size(), "Hamburger", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", 12.99));
		foods.add(new FoodItem(foods.size(), "Tacos", "http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg", "Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa.!", 17.95));
		foods.add(new FoodItem(foods.size(), "Wings", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch.!", 15.95));
		getServletContext().setAttribute("foods", foods);
		
	}
    
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<FoodItem> custItems = (List<FoodItem>) getServletContext().getAttribute("custItems");
		
		request.getRequestDispatcher("/order.jsp")
        .forward(request, response);
		
		int id = Integer.parseInt(request.getParameter("remove"));
		List<FoodItem> newCustItems = (List<FoodItem>) getServletContext().getAttribute("newCustItems");
		
				
				int index = -1;
				
				for(int i = 0; i<newCustItems.size(); i++) {
					if(newCustItems.get(i).getId() == id) {
						index = i;
					}
				}
				
				newCustItems.remove(index);
				
				getServletContext().setAttribute("newCustItems", newCustItems);
	
				request.getRequestDispatcher("../order.jsp")
		        .forward(request, response);
		
		/*response.setContentType("text/html");
		out.println("<body bgcolor='lightgray'>");
				
		out.println("<h2>Your Cart</h2>");
		
		
		out.println("<table cellspacing='15px'>");
		out.println("<tr>");
		out.println("<th>Item</th>");
		out.println("<th>Price</th>");
		out.println("<th>Quantity</th>");
		out.println("</tr>");
		
		for (FoodItem item: custItems){
			
			out.println("<tr>" +
					"<td><center><img src ='" + item.getImageUrl() + "' alt='image' style='width:50px;height:50px' />" + item.getName() + " </center></td>" +
					"<td>" + item.getPrice() + "</td>" +
					"<td>1</td>" +
					"<td><button>Delete</button></td> " +					
					"</tr>");
		}
		out.println("</table>");
		
		out.println("<button>Place Order</button>");
		
		out.println("<footer>&copy; 2017 The Good Food, Inc. All Rights Reserved</footer>");
		
		
		out.println("</body>");
	
*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		List<FoodItem> newCustItems = (List<FoodItem>) getServletContext().getAttribute("newCustItems");
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		request.setAttribute("newCustItems", newCustItems);
		
		orders.add(new Order(orders.size(), newCustItems, "ANONYMOUS", statuses.IN_QUEUE, new Date()));
		
		request.getRequestDispatcher("/statuses.jsp")
		.forward(request, response);
	}

}