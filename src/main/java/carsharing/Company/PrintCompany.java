package carsharing.Company;

import carsharing.Maneger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintCompany extends Connect{
    public static void printTable() {
        List<Company> companies = new ArrayList<>();
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT id, name FROM company";
            ResultSet rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                System.out.println("The company list is empty!");
                return;
            }

            rs.previous();
            while(rs.next()) {
                int id  = rs.getInt("id");
                String name = rs.getString("name");

                companies.add(new Company(id, name));
            }
            rs.close();
            Maneger.carAction(companies);
        } catch(SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
