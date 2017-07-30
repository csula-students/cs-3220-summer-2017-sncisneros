package edu.csula.cs3220.examples;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;;


@WebServlet("/guestbook/delete")
public class DeleteGuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteGuestBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		int index = -1;		
		for(int i=0; i<entries.size(); i++){
			if(entries.get(i).getId() == id){
				index = i;
				}
			}
		entries.remove(index);
		getServletContext().setAttribute("entries", entries);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='/guestbook'>go back to guestbook</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
