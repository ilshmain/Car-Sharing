package carsharing.Company;

import java.sql.*;
import java.util.Scanner;

public class InsertCompany extends Connect {

    public static void insertValueTable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the company name:");

        try{
            Connection conn = Connect.connect();
            String sql = "INSERT INTO COMPANY (NAME) VALUES (?)";
            String sqlQuery = "SELECT * FROM COMPANY";
            String resetId = "ALTER TABLE COMPANY ALTER COLUMN ID RESTART WITH 1";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                statement.executeUpdate(resetId);
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.executeUpdate();

            System.out.println("The company was created!");

            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
