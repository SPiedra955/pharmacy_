import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Release")
public class Release extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el cuerpo de la solicitud
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        // Configurar el ObjectMapper para deserializar los datos JSON
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Deserializar los datos JSON en un objeto Java
            ReleaseData releaseData = mapper.readValue(requestBody, ReleaseData.class);

            // Obtener los valores de los campos del objeto
            String email = releaseData.getEmail();
            String idXip = releaseData.getIdXip();
            String med = releaseData.getMed();
            String date = releaseData.getDate();
            String mailP = releaseData.getMailP();

            // Configurar los detalles de la conexión a la base de datos
            String dbUrl = "jdbc:mysql://localhost:3301/farmacia";
            String username = "root";
            String password = "1234";

            try {
                // Establecer la conexión con la base de datos
                Connection connection = DriverManager.getConnection(dbUrl, username, password);

                // Obtener el ID de la medicina basado en el valor de med
                String selectQuery = "SELECT id FROM medicine WHERE name = ?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                selectStatement.setString(1, med);
                ResultSet resultSet = selectStatement.executeQuery();

                // Verificar si se encontró un resultado
                if (resultSet.next()) {
                    // Obtener el ID de la medicina
                    int idMedicine = resultSet.getInt("id");

                    // Preparar la sentencia SQL para la inserción
                    String insertQuery = "INSERT INTO xip (id, doctor_mail, id_medicine, id_patient, date) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setString(1, idXip);
                    insertStatement.setString(2, email);
                    insertStatement.setInt(3, idMedicine); // Utilizar el ID de la medicina obtenido
                    insertStatement.setString(4, mailP);
                    insertStatement.setString(5, date);

                    // Ejecutar la sentencia de inserción
                    insertStatement.executeUpdate();

                    // Cerrar los recursos
                    insertStatement.close();
                } else {
                    // La medicina no fue encontrada, manejar el caso apropiadamente
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println("La medicina no existe");
                    return;
                }

                // Cerrar los recursos
                resultSet.close();
                selectStatement.close();
                connection.close();

                // Mostrar la alerta "Dato insertado"
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("<script>alert('Dato insertado');</script>");
            } catch (SQLException e) {
                // Manejar el error apropiadamente
                System.out.println("Error en la inserción del registro: " + e.getMessage());
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().println("Error en la inserción del registro");
            }
        } catch (IOException e) {
            // Manejar el error apropiadamente
            System.out.println("Error en el formato de los datos JSON: " + e.getMessage());
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error en el formato de los datos JSON");
        }
    }
}
