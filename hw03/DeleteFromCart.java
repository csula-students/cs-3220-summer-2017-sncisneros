package edu.csula.cs3220.hw03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/shopping-cart/delete")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> newCustItems = (List<FoodItem>) getServletContext().getAttribute("newCustItems");
		
				
				int index = -1;
				
				for(int i = 0; i<newCustItems.size(); i++) {
					if(newCustItems.get(i).getId() == id) {
						index = i;
					}
				}
				
				newCustItems.remove(index);
				
				getServletContext().setAttribute("newCustItems", newCustItems);
				
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Item has been Deleted.</h2>");
		out.println("<button><a href='../shopping-cart'>Back To My Cart</a></button>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
