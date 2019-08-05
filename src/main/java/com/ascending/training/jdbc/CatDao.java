package com.ascending.training.jdbc;

import com.ascending.training.model.Cat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5433/project_db";
    static final String USER = "admin";
    static final String PASS = "kkmacs213";

    public List<Cat> getCats(){
        List<Cat> cats = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Step 2. Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 3. Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Cats";
            rs = stmt.executeQuery(sql);

            //Step 4. Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("cat_name");

                //Fill the object
                Cat cat = new Cat();
                cat.setId(id);
                cat.setName(name);
                cats.add(cat);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }

        return cats;
    }

    public static void main(String[] args){
        CatDao catDao = new CatDao();
        List<Cat> cats = catDao.getCats();

        for(Cat cat : cats){
            System.out.println(cat.getName());
        }
    }

}




