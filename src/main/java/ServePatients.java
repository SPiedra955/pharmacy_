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
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Crear una declaración para ejecutar la consulta SQL
            Statement statement = connection.createStatement();

            // Ejecutar la consulta SQL para obtener los datos de la columna "mail" de la tabla "patient"
            String selectQuery = "SELECT email FROM patient";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Crear una lista para almacenar los resultados
            List<String> patients = new ArrayList<>();

            // Obtener los datos de la columna "mail"
            while (resultSet.next()) {
                String patientMail = resultSet.getString("email");
                patients.add(patientMail);
            }

            // Convertir la lista de pacientes a formato JSON
            String json = new Gson().toJson(patients);

            // Configurar la respuesta HTTP
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Enviar la respuesta JSON al cliente
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();

            // Cerrar los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar el error apropiadamente
        }
    }
}
