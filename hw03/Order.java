package edu.csula.cs3220.hw03;
import java.util.*;

public class Order {
	
	public enum statuses{IN_QUEUE, IN_PROGRESS, COMPLETED;};
	
	public final int id;
	public final List<FoodItem> items;
	public final String custName;
	public final Date created;
	public statuses statuses;
	
	public Order(int id, List<FoodItem> custItems, String custName, statuses status, Date created) {
		
		this.id = id;
		this.items = custItems;
		this.custName = custName;
		this.statuses = status;
		this.created = created;
		
	}


	public int getId() {
		return id;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public String getCustName() {
		return custName;
	}

	public Date getCreated() {
		return created;
	}

	public statuses getStatuses() {
		return statuses;
	}

	public void setStatuses(statuses statuses) {
		this.statuses = statuses;
	}

	
}
