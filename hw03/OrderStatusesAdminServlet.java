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



@WebServlet(loadOnStartup=1, urlPatterns= {"/admin/orders"})
public class OrderStatusesAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderStatusesAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
public void init() {
		
	List<Order> orders = new ArrayList<>();
	List<FoodItem> custItems = new ArrayList<>();
	List<FoodItem> custItems1 = new ArrayList<>();
	
	
	custItems.add(new FoodItem(custItems.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
	getServletContext().setAttribute("custItems", custItems);

	custItems1.add(new FoodItem(custItems.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
	custItems1.add(new FoodItem(custItems.size(), "Buffalo Wings", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch.", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", 15.95));
	getServletContext().setAttribute("custItems1", custItems1);
	
	
	orders.add(new Order(orders.size(), custItems, "Joanna", statuses.IN_QUEUE, new Date()));
	orders.add(new Order(orders.size(), custItems1, "Brandon", statuses.IN_QUEUE, new Date()));
	getServletContext().setAttribute("orders", orders);
	
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItem> custItems = (List<FoodItem>) getServletContext().getAttribute("custItems");
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		//request.getRequestDispatcher("/order-status.jsp")
      // .forward(request, response);
		response.setContentType("text/html");
		/*
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("<link rel='stylesheet' type='text/css' href='../app.css'>");
		out.println("<title>lab 1</title>");
		out.println("</head>");
		
		
		
		out.println("<header>");
		out.println("<img class='main' src='https://static.pexels.com/photos/5317/food-salad-restaurant-person.jpg'>");
	
		out.println("<h1>The Good Food</h1>");

		out.println("<section class='navigation'>");
		out.println("<nav>" +	
			"<a href='menu.html'>Menu </a>|" +
			"<a href='index.html'>Order </a>|"+
			"<a href='statuses.html'>Status</a>" +
			"</nav>");
		out.println("</section>");

		out.println("</header>");
		*/
		
		out.println("<body bgcolor='lightgray'>");
		out.println("<h2>Order Status - Admin</h2>");
		
		out.println("<table cellspacing='15px'>");
		
		out.println("<tr>");	
		out.println("<th>Date Created</th>");
		out.println("<th>Items</th>");
		out.println("<th>Customer Name</th>");
		out.println("<th>Status</th>");
		out.println("<th>Update</th>");
		out.println("</tr>");
		
		for (Order order: orders){
			
			out.println("<tr align='center'>" +
					"<td>" + order.getCreated() + " : </td>" +
					"<td>" + order.getItems() + " /></td>" +
					"<td>" + order.getCustName() + "</td>" +
					"<td>" + order.getStatuses() + "</td>" +
					"<td><a href='../admin/orders/edit?id=" + order.getId() + "'>Update Status</a></td> " +
					"</tr>");
		}
		out.println("</table>");
		
		out.println("<br/>");
		out.println("<footer>&copy; 2017 The Good Food, Inc. All Rights Reserved</footer>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
