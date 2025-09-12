public class Worker{
    private int id;
    private String nombre;
    private double  sueldo;

    public Worker(int id, String nombre, double sueldo){
        this.id=id;
        this.nombre=nombre;
        this.sueldo=sueldo;
    }
    public Worker(){}

    public int getId(){
        return id;
    }
     public String getNombre(){
        return nombre;
    }
    public double getSueldo(){
        return sueldo;
    }

    public void setId(int newId) {
        this.id = newId;
    }
    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }
    public void setSueldo(double newSueldo) {
        this.sueldo = newSueldo;
    }

}
