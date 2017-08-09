package edu.csula.jaxrs.lab07;


import java.util.ArrayList;
import java.util.Arrays;
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

import edu.csula.jaxrs.models.FoodItem;
import edu.csula.jaxrs.models.FoodItemDAO;

@Path("foodresource")
@Singleton
public class FoodResource {
	private List<FoodItem> items = new ArrayList<>(Arrays.asList(new FoodItem(1, "Hamburger", "An all-American burger, made medium-well, with a whole wheat bun. Unlimited fries included!", "http://toriavey.com/images/2013/08/Hamburger-History-1.jpg", 12.99)));
	
	
	
    @GET
    @Path("fooditems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodItem> getFoodItems() {
    	FoodItemDAO dao = new FoodItemDAO();
    	return dao.list();
     
    }
    
    @GET
    @Path("fooditems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodItem getFoodItem(@PathParam("id") int id) {
    	System.out.println(id); //testing purpose
    	FoodItemDAO dao = new FoodItemDAO();
    	return items.get(id);
        
    }
    
    
    @POST
    @Path("fooditems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addItem(FoodItem newItem) {
    	FoodItemDAO dao = new FoodItemDAO();
    	dao.add(newItem);
    	return true;
    }
    
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteItem(@PathParam("id") int id) {
    	System.out.println(id);
    	FoodItemDAO dao = new FoodItemDAO();
    	dao.delete(id);
    	return true;
    	
    }
    
    @PUT
    @Path("fooditems/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateItem(FoodItem item, @PathParam("id") int id) {
    	System.out.println(id);
    	FoodItemDAO dao = new FoodItemDAO();
    	dao.update(item);
    	return true;
    }
}
