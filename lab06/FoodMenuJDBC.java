package edu.csula.cs3220.lab06;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import edu.csula.cs3220.examples.GuestBookEntry;
import edu.csula.cs3220.hw03.Order.statuses;


@WebServlet(loadOnStartup = 1, urlPatterns={"/lab06/menu"})
public class FoodMenuJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FoodMenuJDBC() {
        super();
        // TODO Auto-generated constructor stub
        
       
    }
    
   /* public void init( ServletConfig config ) throws ServletException {
        super.init( config );

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch( ClassNotFoundException e ) {
            throw new ServletException( e );
        }
    }
*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
         * foods.add(new FoodItem(foods.size(), "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99));
		foods.add(new FoodItem(foods.size(), "Tacos", "Three tacos with grilled chicken, and a side of rice and beans. Your choice of salsa!", "http://www.smells-like-home.com/wp-content/uploads/2012/08/roast-chicken-tacos-with-cilantro-cream-1.jpg", 17.95));
		foods.add(new FoodItem(foods.size(), "Buffalo Wings", "Ten chicken wings soaked in a spicy buffalo sauce. Served with ranch!", "http://fodmapliving.com/wp-content/uploads/2013/01/buffalo-wings.jpg", 15.95));
		
         */
	
	
		

        FoodItemDAO dao = new FoodItemDAO();
        request.setAttribute("list", dao.list());

        request.getRequestDispatcher("/jdbc/indexjdbc.jsp")
            .forward(request, response);
	}

}
