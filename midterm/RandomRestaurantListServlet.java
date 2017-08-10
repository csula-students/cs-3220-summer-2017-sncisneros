package edu.csula.cs3220.midterm;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import edu.csula.cs3220.lab03.FoodItem;

import java.util.List;


@WebServlet(loadOnStartup=1, urlPatterns={"/restaurants/random/list/"})
public class RandomRestaurantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RandomRestaurantListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	
    	List<Restaurant> restaurants = new ArrayList<>();
    	
    	for(int i=1; i<23; i++) {
    		int designRatings[] = new int[22] ;
    		int tasteRatings[] = new int[22];
    		String name = "Student " + i +" Restaurant";
    		String url =  "http://cs3.calstatela.edu:8080/cs3220xstu"+i+"/menu";
    		Restaurant temp = new Restaurant(restaurants.size(), name, url , designRatings, tasteRatings);
    		restaurants.add(temp);    			
   	}
    	getServletContext().setAttribute("restaurants", restaurants);
  	
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<h1>Whats For Lunch?</h1>");
		
		
		List<Restaurant> restaurants = (List<Restaurant>) getServletContext().getAttribute("restaurants");
			
		
		
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>URL</th>");
		out.println("<th>Design</th>");
		out.println("<th>Taste</th>");
		out.println("</tr>");
		
		for (Restaurant restaurant: restaurants){
			
			out.println("<tr>" +
					"<td>" + restaurant.getName() + "</td>" +
					"<td>" + restaurant.getUrl() + "</td>" +
					"<td>0</td>" +
					"<td>0</td>" +					
					"</tr>");
		} 
		out.println("</table>");
		out.println("<center><button>Feeling Lucky</button>");
		out.println("<a href='/restaurants/random/list'><button>See The List</button></a></center>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
