public class Patient extends Person {
    // Constructores
    public Patient() {
        super();
    }

    public Patient(String name, String email) {
        super(name, email);
    }

    // Métodos
    @Override
    public void load(String id) {
        // Cargar los datos del paciente correspondientes a id desde la base de datos (BBDD.patient.mail)
    }
}