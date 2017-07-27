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
		
		request.getRequestDispatcher("/order.jsp")
        .forward(request, response);
		
				
		/*response.setContentType("text/html");
		
		out.println("<body bgcolor='pink'>");
		
		out.println("<h1>The Good Food</h1>");
		out.println("</br>");
		
		out.println("<h2>Food Menu</h2>");
		
		out.println("<table>");
		for (FoodItem food: foods){
			
			out.println("<tr>" +
					"<td>" + food.getName() + " : </td>" +
					"<td><img src ='" + food.getImageUrl() + "' alt='image' style='width:50px;height:50px' /></td>" +
					"<td>" + food.getDescription() + "</td>" +
					"<td>" + food.getPrice() + "</td>" +					
					"</tr>");
		}
		out.println("</table>");
		
		out.println("</body>");
		*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
