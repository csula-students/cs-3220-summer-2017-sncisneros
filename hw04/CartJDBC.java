package edu.csula.cs3220.lab06;

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

import edu.csula.cs3220.hw03.FoodItem;
import edu.csula.cs3220.lab06.Order.statuses;


@WebServlet(loadOnStartup=1, urlPatterns= {"/lab06/shopping-cart"})
public class CartJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	    
    public CartJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		List<FoodItem> foods = new ArrayList<>();
		
		foods.add(new FoodItem(foods.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
		foods.add(new FoodItem(foods.size(), "Tacos", "Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa.!", "http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg", 17.95));
		foods.add(new FoodItem(foods.size(), "Wings", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch!", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", 15.95));
		getServletContext().setAttribute("foods", foods);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> newCustItems = (List<FoodItem>) request.getSession().getAttribute("newCustItems");
		
		
		request.getRequestDispatcher("../orderjdbc.jsp")
        .forward(request, response);
		
		int id = Integer.parseInt(request.getParameter("remove"));
		
				
				int index = -1;
				
				for(int i = 0; i<newCustItems.size(); i++) {
					if(newCustItems.get(i).getId() == id) {
						index = i;
					}
				}
				
				newCustItems.remove(index);
				
				request.getSession().setAttribute("newCustItems", newCustItems);
	
				//request.getRequestDispatcher("../orderjdbc.jsp")
		    //    .forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<FoodItem> newCustItems = (List<FoodItem>) request.getSession().getAttribute("newCustItems");
		
		OrderDAO dao = new OrderDAO();
		
		for(int i=0; i < newCustItems.size(); i++) {
		Order newOrder = new Order(-1, newCustItems.get(i).getId(), "ANONYMOUS", statuses.IN_QUEUE, new Date());
		dao.add(newOrder);
		}
		
		response.sendRedirect("/jdbc/statusesjdbc.jsp");
		}

}
