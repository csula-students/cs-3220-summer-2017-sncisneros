package edu.csula.cs3220.lab06;

import edu.csula.cs3220.lab06.DAO;
import edu.csula.cs3220.lab06.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class FoodItemDAO implements DAO<FoodItem> {
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("imageurl"),
                    rs.getDouble("price")
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

    public void add(FoodItem entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO food_items (name, description, imageurl, price) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDescription());
            pstmt.setString(3, entry.getImageUrl());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodItem entry) {

    }

    public void delete(int id) {
    }
}
