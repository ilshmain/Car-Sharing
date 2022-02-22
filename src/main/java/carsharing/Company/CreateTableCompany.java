package carsharing.Company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableCompany extends Connect {

    public static void createTable() {

        String sCreateCompanyTable = "CREATE TABLE IF NOT EXISTS COMPANY " +
                "(ID INTEGER AUTO_INCREMENT, " +
                "NAME VARCHAR(100) UNIQUE NOT NULL," +
                "PRIMARY KEY (ID)" +
                ")";
        String sCreateCarTable = "CREATE TABLE IF NOT EXISTS CAR" +
                "(ID INTEGER AUTO_INCREMENT, " +
                "NAME VARCHAR(100) UNIQUE NOT NULL, " +
                "COMPANY_ID INTEGER NOT NULL, " +
                "PRIMARY KEY (ID), " +
                "CONSTRAINT fk_company_id " +
                "FOREIGN KEY (COMPANY_ID) " +
                "REFERENCES COMPANY(ID)" +
                ")";
        try {
            Connection conn = Connect.connect();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sCreateCompanyTable);
            stmt.executeUpdate(sCreateCarTable);

            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }
}
