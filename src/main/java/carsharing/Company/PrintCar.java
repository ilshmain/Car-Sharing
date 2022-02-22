package carsharing.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PrintCar extends Connect {

        private static void printCars(List<Car> cars) {
            int num = 1;
            for (Car car : cars) {
                System.out.print(num);
                System.out.println(". " + car.getName());
                num++;
            }
        }

        public static void printCar(int num) {
            List<Car> cars = new ArrayList<>();
        try {
            String sqlQuery = "Select * FROM CAR WHERE COMPANY_ID = " + num;
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sqlQuery);

            if (!rs.next()) {
                System.out.println("The car list is empty!");
                return;
            }

            rs.previous();
            while(rs.next()) {
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                cars.add(new Car(id, name, num));
            }
            rs.close();
            printCars(cars);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        }
}
