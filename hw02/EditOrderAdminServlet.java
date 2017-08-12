package edu.csula.cs3220.hw02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.hw02.Order.statuses;


@WebServlet("/admin/orders/edit")
public class EditOrderAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditOrderAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> custItems = (List<FoodItem>) getServletContext().getAttribute("custItems");
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		Order eOrder = null;
		for (Order order: orders) {
			if (order.getId() == id) {
				eOrder = order;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		out.println("<body bgcolor='lightgray' color='slategray'>");
		
		out.println("<h1>Update Statuses</h1>");
		
		out.println("<form method=\"post\">");
		out.println("Created: " + eOrder.getCreated());
		out.println("<br/>Customer Name : <input name='name' type='text' value='" + eOrder.getCustName() + "'/></br>");
		out.println("Customers Items : <textarea name='items'>" + eOrder.getItems() + "</textarea></br>");
		out.println("Choose Status : <select id='status' name='status'><option value='progress'>" +statuses.IN_PROGRESS+ "</option>" +
						"<option value='queue'>" + statuses.IN_QUEUE +"</option>" +
						"<option value='complete'>" + statuses.COMPLETED + "</option>" +
						"</select>");
		out.println("<button>Update</button>");
		out.println("</form>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
				
				int id = Integer.parseInt(request.getParameter("id"));
				List<FoodItem> custItems = (List<FoodItem>) getServletContext().getAttribute("custItems");
				List<FoodItem> custItems1 = (List<FoodItem>) getServletContext().getAttribute("custItems1");
				
				List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
				
				Order eOrder = null;
				int index = -1;
				for (int i = 0; i < orders.size(); i++) {
					if (orders.get(i).getId() == id) {
						eOrder = orders.get(i);
						index = i;
					}
				}
				orders.set(index, new Order(
					eOrder.getId(),
					eOrder.getItems(),
					request.getParameter("name"),
					statuses.valueOf(request.getParameter("status")),
					eOrder.getCreated()
				));
				getServletContext().setAttribute("orders", orders);

				PrintWriter out = response.getWriter();
				out.println("<a href='/admin/orders'>Back To Orders</a>");
			//	response.sendRedirect("../admin/orders");
	}

}
