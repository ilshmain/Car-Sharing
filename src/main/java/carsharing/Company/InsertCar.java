package carsharing.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCar {
    public static void insertValueCar(int compamyId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the car name:");

        try{
            Connection conn = Connect.connect();
            String sql = "INSERT INTO CAR (NAME, COMPANY_ID) VALUES (?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, scanner.nextLine());
            preparedStatement.setInt(2, compamyId);
            preparedStatement.executeUpdate();

            System.out.println("The car was added!");

            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
