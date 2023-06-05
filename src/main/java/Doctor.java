import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Doctor extends Person {
    private String pass;
    private LocalDate lastLog;
    private String session;
    private ArrayList<Xip> releaseList;

    public Doctor() {
        super();
    }

    public Doctor(String pass, LocalDate lastLog, String session) {
        super();
        this.setPass(pass);
        this.setLastLog(lastLog);
        this.setSession(session);
    }

    public String login(String email, String pass) {
        ConnectionDB db = new ConnectionDB();
        String session = null;
        try {
            if (db.connect()) {
                String query = "SELECT * FROM doctor WHERE email = ? AND pass = ?";
                PreparedStatement statement = db.getConn().prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, pass);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Inicio de sesión correcto.");
                    session = generateSession(); // Generar el código de sesión (puedes implementar tu propia lógica aquí)

                    // Actualizar la columna "last_log" y "session" en la base de datos
                    LocalDate currentDate = LocalDate.now();
                    String updateQuery = "UPDATE doctor SET last_log = ?, session = ? WHERE email = ?";
                    PreparedStatement updateStatement = db.getConn().prepareStatement(updateQuery);
                    updateStatement.setString(1, currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    updateStatement.setString(2, session);
                    updateStatement.setString(3, email);
                    updateStatement.executeUpdate();
                } else {
                    System.out.println("Credenciales inválidas.");
                }
            } else {
                System.out.println("Error al conectar con la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return session;
    }

    private String generateSession() {
        Random random = new Random();
        StringBuilder sessionNumber = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10);
            sessionNumber.append(digit);
        }
        System.out.println("Código de sesión generado: " + sessionNumber);
        return sessionNumber.toString();
    }

    public boolean isLogged(String email, String session) {
        // Implementa la lógica para verificar si el usuario está registrado con la sesión proporcionada
        return false;
    }

    @Override
    public void load(String id) {
        // Implementa la lógica para cargar los datos del doctor con el ID proporcionado
    }

    public void loadReleaseList() {
        // Implementa la lógica para cargar la lista de registros de alta del doctor
    }

    public String getTable() {
        // Implementa la lógica para obtener el nombre de la tabla correspondiente al doctor
        return "";
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getLastLog() {
		return lastLog;
	}

	public void setLastLog(LocalDate lastLog) {
		this.lastLog = lastLog;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public ArrayList<Xip> getReleaseList() {
		return releaseList;
	}

	public void setReleaseList(ArrayList<Xip> releaseList) {
		this.releaseList = releaseList;
	}


}
