package edu.csula.cs3220.lab06;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.hw03.Order.statuses; 

@WebServlet(loadOnStartup=1, urlPatterns= {"/lab06/order"})
public class OrderStatusesJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public OrderStatusesJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderDAO dao = new OrderDAO();
        request.setAttribute("list", dao.list());

      	request.getRequestDispatcher("/jdbc/statusesjdbc.jsp")
        .forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
