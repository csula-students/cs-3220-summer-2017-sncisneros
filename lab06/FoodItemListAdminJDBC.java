package edu.csula.cs3220.lab06;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;


@WebServlet(loadOnStartup = 1, urlPatterns={"/lab06/admin/foods/"})
public class FoodItemListAdminJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
    public FoodItemListAdminJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FoodItemDAO dao = new FoodItemDAO();
	        request.setAttribute("list", dao.list());

	      request.getRequestDispatcher("/jdbc/inventoryjdbc.jsp")
	           .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
