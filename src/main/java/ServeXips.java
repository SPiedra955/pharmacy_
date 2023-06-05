import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServeXips")
public class ServeXips extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        try {           
            String tableData = getTableData(email);
            if (tableData != null) {
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println(tableData);
            } else {
                System.out.println("No se encontraron resultados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error en la obtención de los datos");
        }
    }
    private String getTableData(String email) throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3301/farmacia";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        String selectQuery = "SELECT id, doctor_mail, id_medicine, id_patient, date FROM xip WHERE doctor_mail = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            StringBuilder tableData = new StringBuilder();
            tableData.append("<table>");
            tableData.append("<tr><th>Id</th><th>Doctor Email</th><th>Id Medicine</th><th>Patient Email</th><th>Date</th></tr>");
            do {
                int id = resultSet.getInt("id");
                String doctorEmail = resultSet.getString("doctor_mail");
                int medicineId = resultSet.getInt("id_medicine");
                String patientEmail = resultSet.getString("id_patient");
                String date = resultSet.getString("date");
                tableData.append("<tr>");
                tableData.append("<td>").append(id).append("</td>");
                tableData.append("<td>").append(doctorEmail).append("</td>");
                tableData.append("<td>").append(medicineId).append("</td>");
                tableData.append("<td>").append(patientEmail).append("</td>");
                tableData.append("<td>").append(date).append("</td>");
                tableData.append("</tr>");
            } while (resultSet.next());
            tableData.append("</table>");
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("Cargando tabla...");
            return tableData.toString();
        } else {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return null;
        }
    }
}
