package Persist;
 
import java.sql.*;
import java.util.ArrayList;

import Core.Category;

/**
* @generated
*/
public class CategoryDaoMySQL implements CategoryDao {

    private AbstractFactoryDao creator;

    public CategoryDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    @Override
    public ArrayList<Category> getCategories() {
        String requete = "SELECT * from categories";
        Connection con = creator.getConnection();
        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2)); 
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    } 

    @Override
    public void deleteCategoryById(int id) {
        String requete = "delete from categories where id = " + id;
        Connection con = creator.getConnection(); 
        try {
            Statement stmt = con.createStatement();
            stmt.execute(requete);  
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }

    @Override
    public void addCategory(Category c) {
        String requete = "INSERT INTO categories (id, name) VALUES (NULL, \""+  c.getName() +"\")";
        Connection con = creator.getConnection(); 
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(requete);  
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }

    @Override
    public void updateCategory(Category c) { 
        String requete = "UPDATE categories SET name = \"" + c.getName() + "\" WHERE id = " + c.getId();
        Connection con = creator.getConnection(); 
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(requete);  
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }  
} 
