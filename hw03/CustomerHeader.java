package edu.csula.cs3220.hw03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomerHeader extends SimpleTagSupport {
	String title;
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	 public void doTag() throws JspException, IOException {
	      JspWriter out = getJspContext().getOut();
	      out.println("<link rel=\"stylesheet\" href=\"/app.css\">");
	     
	      out.println("<header>");
	      out.println("<img class=\"main\" src=\"https://static.pexels.com/photos/5317/food-salad-restaurant-person.jpg\">");
	      out.println("<h1>"+ title +"</h1>");
	      //out.println("<section class='navigation'><nav>");
	      out.println("<a href='./menu'>Menu </a>|");
	      out.println("<a href='./shopping-cart'>Order </a>|");
	      out.println("<a href='./order'>Status</a>");
	     // out.println("</nav></section");
	      out.println("</header>");

	      
	     
	    }

}