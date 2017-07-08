package edu.csula.cs3220.lab03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/foods/edit")
public class EditFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//get correct entry, through scope
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		
		FoodItem editFood = null;
		for(FoodItem food: foods){
			if(food.getId() == id)
				editFood = food;
		}
			
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	
			out.println("<h1>Edit Food Item</h1>");
			out.println("<form method=\"post\">");
			out.println("Food name: <input name='name' type='text' value=' " + editFood.getName() + " ' /></br>");
			out.println("Description: <textarea name='description'>" + editFood.getDescription() + "</textarea></br>");
			out.println("Image url: <input name='imageUrl' type='text' value=' " + editFood.getImageUrl() + " ' /></br>");
			out.println("Food Price: <input name='price' type='number' value=' " + editFood.getPrice() + " ' /></br>");
			out.println("<button>Add</button>");
			out.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> foods = (List<FoodItem>) getServletContext().getAttribute("foods");
		
		
		FoodItem editFood = null;
		int index = -1;
		
		for(int i=0; i<foods.size(); i++){
			if(foods.get(i).getId() == id){
				editFood = foods.get(i);
				index = i;
				}
			}
		
		foods.set(index, new FoodItem(
				editFood.getId(),
				request.getParameter("name"),
				request.getParameter("description"),
				request.getParameter("imageUrl"),
				Double.parseDouble(request.getParameter("price"))
				));
		getServletContext().setAttribute("foods", foods);
		
		PrintWriter out = response.getWriter();
		out.println("<a href='/admin/foods/'>Back To Food List</a>");
	}

}


