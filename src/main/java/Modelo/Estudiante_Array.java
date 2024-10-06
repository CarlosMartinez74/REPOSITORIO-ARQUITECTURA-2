package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante_Array {

    private List<Estudiante> estudiantes;
    private int contadorCodigo = 1; // Iniciamos en 1

    public Estudiante_Array() {
        this.estudiantes = new ArrayList<>();
    }

    public String generarCodigo() {
        return String.format("%04d", contadorCodigo++); // Generar el código incremental
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }

    public void modificarEstudiante(Estudiante estudiante) {
        for (Estudiante e : this.estudiantes) {
            if (e.getCodigo().equals(estudiante.getCodigo())) {
                e.setNombre(estudiante.getNombre());
                e.setDireccion(estudiante.getDireccion());
                e.setNumero(estudiante.getNumero());
                e.setEdad(estudiante.getEdad());
                break;
            }
        }
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public List<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }
}
