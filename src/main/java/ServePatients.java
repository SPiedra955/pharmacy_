import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ServePatients")
public class ServePatients extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configurar los detalles de la conexión a la base de datos
        String dbUrl = "jdbc:mysql://localhost:3301/farmacia";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT email FROM patient";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            List<String> patients = new ArrayList<>();
            while (resultSet.next()) {
                String patientMail = resultSet.getString("email");
                patients.add(patientMail);
            }
            // Convertir la lista de pacientes a formato JSON
            String json = new Gson().toJson(patients);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            // Enviar la respuesta JSON al cliente
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
