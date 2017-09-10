package br.com.dfmachado.listadefilmes.models.connection;

import br.com.dfmachado.listadefilmes.exceptions.GenericCustomException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego.felipe
 */
public class ConnFactory {

    private static Connection conn = null;
    private final String user;
    private final String pass;
    private final String url;

    private ConnFactory() {
        this.user = "sa";
        this.pass = "1234";
        this.url = "lib/DBFilmes";
    }

    public static Connection createConnection() throws SQLException {
        try {
            ConnFactory cf = new ConnFactory();
            if (!HSQL_Manage.isDatabaseExists(cf.url)) {
                conn = DriverManager.getConnection(
                        "jdbc:hsqldb:file:" + cf.url, cf.user, cf.pass);
                HSQL_Manage.createDatabase(conn);
            } else {
                conn = DriverManager.getConnection(
                        "jdbc:hsqldb:file:" + cf.url, cf.user, cf.pass);
            }
        } catch (SQLException e) {
            throw new GenericCustomException(e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) throws SQLException {
        close(conn, null, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) throws SQLException {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        close(conn, ps, rs);
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.prepareStatement("shutdown").execute();
            conn.close();
        }
    }
}
