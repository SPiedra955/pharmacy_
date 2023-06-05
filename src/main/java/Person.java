public abstract class Person {
        // Atributos
        protected String name; // Nombre completo de la persona
        protected String email;
    
        // Constructores
        public Person() {
            // Constructor vacío
        }
    
        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }
    
        // Métodos
        public abstract void load(String id);
    
}
