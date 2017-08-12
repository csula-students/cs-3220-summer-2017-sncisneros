package edu.csula.cs3220.lab06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.cs3220.hw03.Order.statuses;



@WebServlet(loadOnStartup=1, urlPatterns= {"/lab06/admin/orders"})
public class OrderStatusesAdminJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderStatusesAdminJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderDAO dao = new OrderDAO();
        request.setAttribute("list", dao.list());

     	request.getRequestDispatcher("/jdbc/order-statusesjdbc.jsp")
       .forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.getRequestDispatcher("/jdbc/order-status.jsp").forward(request, response);
	}

}
