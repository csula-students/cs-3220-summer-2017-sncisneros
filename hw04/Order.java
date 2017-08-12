package edu.csula.cs3220.lab06;
import java.util.*;

public class Order {
	
	public enum statuses{IN_QUEUE, IN_PROGRESS, COMPLETED;};
	
	public final int id;
	public final int itemId;
	public final String custName;
	public final Date created;
	public statuses statuses;
	
	public Order(int id, int itemId, String custName, statuses status, Date created) {
		
		this.id = id;
		this.itemId = itemId;
		this.custName = custName;
		this.statuses = status;
		this.created = created;
		
	}


	public int getId() {
		return id;
	}

	public int getItemId() {
		return itemId;
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
