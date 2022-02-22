package carsharing.Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:C:\\Users\\760760\\IdeaProjects\\Car Sharing\\Car Sharing\\task\\src\\carsharing\\db\\carsharing";

    static public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL,null,null);
        conn.setAutoCommit(true);
        return conn;
    }
}
