import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private Connection conn;
    private Statement st;

    public ConnectionDB() {
        this.conn = null;
        this.st = null;
    }

    public boolean connect() {
        boolean success = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC de MySQL: " + e.getMessage());
            success = false;
        }

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3301/farmacia", "root", "1234");
        } catch (SQLException e) {
            System.out.println("Error al conectar con el servidor MySQL/MariaDB: " + e.getMessage());
            success = false;
        }

        try {
            this.st = this.conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al establecer la declaración de conexión MySQL/MariaDB: " + e.getMessage());
            success = false;
        }

        return success;
    }

    public void close() {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getSt() {
        return st;
    }
}
