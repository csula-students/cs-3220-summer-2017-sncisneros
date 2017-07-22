package edu.csula.cs3220.examples;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;;


@WebServlet("/guestbook/create")
public class CreateGuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(){
		
	}
       
    
    public CreateGuestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//to create a form to fill out
		out.println("<form method=\"post\">");
		out.println("Your name: <input name='name' type='text' /></br>");
		out.println("Comment: <textarea name='comment'></textarea></br>");
		out.println("<button>Add</button>");
		out.println("</form>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		entries.add(new GuestBookEntry(entries.size(), request.getParameter("name"), request.getParameter("comment")));
		
		getServletContext().setAttribute("entries", entries);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='/guestbook'>go back to guestbook</a>");
	}

}
