package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides utility methods for database operations, including obtaining
 * SQL statements, prepared statements, and database connections.
 */
public class Utility {

    private static Statement st;
    private static PreparedStatement pst;

    /**
     * Gets a {@link Statement} object for executing SQL queries.
     * 
     * @return a {@link Statement} object
     * @throws SQLException if a database access error occurs or the URL is invalid
     * @throws ClassNotFoundException if the JDBC driver class is not found
     */
    public static Statement getStatement() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/SaiDB";
        String uname = "sai2005";
        String pwd = "2035";
        Connection con = DriverManager.getConnection(url, uname, pwd);
        st = con.createStatement();
        return st;
    }

    /**
     * Gets a {@link PreparedStatement} object for executing SQL queries with parameters.
     * 
     * @param sql the SQL query string
     * @return a {@link PreparedStatement} object
     * @throws SQLException if a database access error occurs or the SQL string is invalid
     * @throws ClassNotFoundException if the JDBC driver class is not found
     */
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/SaiDB";
        String uname = "sai2005";
        String pwd = "2035";
        Connection con = DriverManager.getConnection(url, uname, pwd);
        pst = con.prepareStatement(sql);
        return pst;
    }

    /**
     * Gets a {@link Connection} object for connecting to the database.
     * 
     * @return a {@link Connection} object
     * @throws ClassNotFoundException if the JDBC driver class is not found
     * @throws SQLException if a database access error occurs or the URL is invalid
     */
    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/SaiDB";
        String uname = "sai2005";
        String pwd = "2035";
        Connection con = DriverManager.getConnection(url, uname, pwd);
        return con;
    }
}
