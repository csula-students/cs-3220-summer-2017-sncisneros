package edu.csula.cs3220.hw02;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.hw02.Order.statuses; 

@WebServlet(loadOnStartup=1, urlPatterns= {"/order"})
public class OrderStatusesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public OrderStatusesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<FoodItem> custItems = (List<FoodItem>) getServletContext().getAttribute("custItems");
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		//request.getRequestDispatcher("/inventory.jsp")
       // .forward(request, response);
		response.setContentType("text/html");
		out.println("<body bgcolor='lightgray'>");
		out.println("<h2>Order Status</h2>");
		out.println("<table cellspacing='15px'>");
		
		out.println("<tr>");	
		out.println("<th>Date Created</th>");
		out.println("<th>Items</th>");
		out.println("<th>Customer Name</th>");
		out.println("<th>Status</th>");
		out.println("</tr>");
		
		for (Order order: orders){
			
			out.println("<tr>" +
					"<td>" + order.getCreated() + " : </td>" +
					"<td><img src ='" + order.getItems() + "' alt='image' style='width:50px;height:50px' /></td>" +
					"<td>" + order.getCustName() + "</td>" +
					"<td>" + order.getStatuses() + "</td>" +
					"</tr>");
		}
		out.println("</table>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
