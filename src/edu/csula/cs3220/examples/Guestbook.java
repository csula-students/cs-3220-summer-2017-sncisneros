package edu.csula.cs3220.examples;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;

/**
 * Servlet implementation class Guestbook
 */
@WebServlet(loadOnStartup=1, urlPatterns={"/guestbook/"})
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(){
		List<GuestBookEntry> entries = new ArrayList<>();
		entries.add(new GuestBookEntry(entries.size(), "Eric", "hello!"));
		entries.add(new GuestBookEntry(entries.size(), "John", "whats up?"));
		getServletContext().setAttribute("entries", entries);
	}
       
   
    public Guestbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		
		out.println("<table>");
		for (GuestBookEntry entry: entries){
			
			out.println("<tr>" +
					"<td>" + entry.getName() + "says: </td>" +
					"<td>" + entry.getComment() + "</td>" +
					"<td><a href='guestbook/edit?id=" + entry.getId() + "'>Edit </a> "
							+ "<a href='guestbook/delete?id=" + entry.getId() + "'>Delete</a></td>" +					
					"</tr>");
		}
		out.println("</table>");
		out.println("<a href='guestbook/create/'>Add Comment</a>");
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
