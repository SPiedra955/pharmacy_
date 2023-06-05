
public class Medicine {
    // Atributos
    private int id;
    private String name;
    private float tmax; // Temperatura máxima
    private float tmin; // Temperatura mínima

    // Constructores
    public Medicine() {
        // Constructor vacío
    }

    public Medicine(int id, String name, float tmax, float tmin) {
        this.id = id;
        this.name = name;
        this.tmax = tmax;
        this.tmin = tmin;
    }

    // Métodos
    public void load(int id) {
        // Cargar los atributos de la base de datos al objeto correspondiente al id en la BBDD
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTmax() {
        return tmax;
    }

    public void setTmax(float tmax) {
        this.tmax = tmax;
    }

    public float getTmin() {
        return tmin;
    }

    public void setTmin(float tmin) {
        this.tmin = tmin;
    }

    
}
