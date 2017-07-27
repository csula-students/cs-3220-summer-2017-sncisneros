package edu.csula.cs3220.hw03;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	String title;
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	 public void doTag() throws JspException, IOException {
	      JspWriter out = getJspContext().getOut();
	      out.println("<link rel=\"stylesheet\" href=\"/app.css\">");
	     
	      out.println("<header>");
	      out.println("<img class=\"main\" src=\"https://static.pexels.com/photos/5317/food-salad-restaurant-person.jpg\">");
	      out.println("<h1>"+ title +" - ADMIN</h1>");
	     // out.println("<section class='navigation'><nav>");
	      out.println("<a href='../foods/'>Inventory </a>|");
	      out.println("<a href='../orders'>Order Statuses</a>");
	    //  out.println("</nav></section");
	      out.println("</header>");

	      
	     
	    }

}
