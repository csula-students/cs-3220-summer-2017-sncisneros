package edu.csula.jaxrs.lab07;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.csula.jaxrs.models.Order;
import edu.csula.jaxrs.models.Order.statuses;
import edu.csula.jaxrs.models.OrderDAO;

@Path("order-resource")
@Singleton
public class OrderResource {
	private List<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, 1, "Ashley", statuses.IN_QUEUE, new Date(8-8-2017))));
	
	
	
    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
    	OrderDAO dao = new OrderDAO();
    	return dao.list();
     
    }
    
    @GET
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getSingleOrder(@PathParam("id") int id) {
    	System.out.println(id); //testing purpose
    	OrderDAO dao = new OrderDAO();
    	return orders.get(id);
        
    }
    
    
    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addOrder(Order newOrder) {
    	OrderDAO dao = new OrderDAO();
    	dao.add(newOrder);
    	return true;
    }
    
    @DELETE
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteItem(@PathParam("id") int id) {
    	System.out.println(id);
    	OrderDAO dao = new OrderDAO();
    	dao.delete(id);
    	return true;
    	
    }
    
    @PUT
    @Path("orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateItem(Order order, @PathParam("id") int id) {
    	System.out.println(id);
    	OrderDAO dao = new OrderDAO();
    	dao.update(order);
    	return true;
    }
}
