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

@WebServlet("/ServeMedicines")
public class ServeMedicines extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dbUrl = "jdbc:mysql://localhost:3301/farmacia";
        String username = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT name FROM medicine";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            // Crear una lista para almacenar los resultados
            List<String> medicineNames = new ArrayList<>();
            // Obtener los nombres de la columna "name"
            while (resultSet.next()) {
                String medicineName = resultSet.getString("name");
                medicineNames.add(medicineName);
            }
            // Convertir la lista de nombres de medicamentos a formato JSON
            String json = new Gson().toJson(medicineNames);
            // Configurar la respuesta HTTP
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
