package edu.csula.cs3220.midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.lab03.FoodItem;

/**
 * Servlet implementation class RandomRestaurantServlet
 */
@WebServlet(loadOnStartup=1, urlPatterns={"/restaurants/random" })
public class RandomRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RandomRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurant> restaurants = (List<Restaurant>) getServletContext().getAttribute("restaurants");
		
	
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<body bgcolor='beige'>");
		
		out.println("<h1><center>Whats For Lunch?</center></h1>");
		out.println("</br>");
		
		out.println("<h3>You should go to:</h3>");
		out.println("<img src='https://github.com/csula/cs3220-summer-2017/blob/master/notes/imgs/restaurant-placeholder.png' alt='image' />");
		out.println("<h3>Name</h3>");
		out.println("<form method=\"post\">");
		out.println("<input name='designRate' type='radio' value='1' checked> 1" +
					"</br>" +
					"<input name='designRate' type='radio' value='2'> 2" +
					"</br>" +
					"<input name='designRate' type='radio' value='3'> 3" +
					"</br>" +
					"<input name='designRate' type='radio' value='4'> 4");
		out.println("</form>");
		out.println("<input name='tasteRate' type='radio' value='1' checked> 1" +
				"</br>" +
				"<input name='tasteRate' type='radio' value='2'> 2" +
				"</br>" +
				"<input name='tasteRate' type='radio' value='3'> 3" +
				"</br>" +
				"<input name='tasteRate' type='radio' value='4'> 4");	
		out.println("<button>Submit</button>");
		out.println("</form>");
		out.println("</br>");
		out.println("<button>Feeling Lucky</button>");
		out.println("<a href='random/list/'><button>See The List</button></a></center>");
		
		out.println("</body>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}
		
}


