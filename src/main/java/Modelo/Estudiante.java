package Modelo;

public class Estudiante {

    private String codigo;
    private String nombre;
    private String direccion;
    private String numero;
    private int edad;

    public Estudiante(String codigo, String nombre, String direccion, String numero, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.edad = edad;
    }

    // Getters y setters para todos los campos

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
