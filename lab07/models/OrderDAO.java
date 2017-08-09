package edu.csula.jaxrs.models;


import edu.csula.jaxrs.models.DAO;
import edu.csula.jaxrs.models.Database;
import edu.csula.jaxrs.models.Order.statuses;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;


public class OrderDAO implements DAO<Order> {
    public List<Order> list() {
        List<Order> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
            	while (rs.next()) {
            	statuses status = statuses.valueOf(rs.getString("status"));
                list.add(new Order(
                    rs.getInt("id"),
                    rs.getInt("item_id"),
                    rs.getString("custName"),
                    status,
                    rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
        return Optional.empty();
    }

    public void add(Order order) {
        Database db = new Database();
        try (Connection c = db.connection()) {
        	PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (item_id, custName, status, created) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, order.getItemId());
            pstmt.setString(2, order.getCustName());
            pstmt.setString(3, order.getStatuses().toString());
            pstmt.setDate(4, (Date) order.getCreated());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Order order) {
    	
    	Database db = new Database();
    	
    	try(Connection c = db.connection()){
    		PreparedStatement pstmt = c.prepareStatement("UPDATE order SET custName='" + order.getCustName() + "', "
    				+ "item_id='" + order.getItemId() + "', status='" + order.getStatuses() 
    				+ "', date=" + order.getCreated() + "WHERE id=" + order.getId());
    		pstmt.executeUpdate();
    	}catch(SQLException e) {
            e.printStackTrace();
        }
    		

    }

    public void delete(int id) {
    	Database db = new Database();
    	
    	try(Connection c = db.connection()){
    		PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders where id=" + id);
    		 pstmt.executeUpdate();
    	}catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
