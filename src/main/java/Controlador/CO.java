package Controlador;

import Modelo.Estudiante;
import Modelo.Estudiante_Array;
import Vista.VistaRegistro;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CO {

    private VistaRegistro vista;
    private Estudiante_Array registroEstudiantes;

    public CO(VistaRegistro vista, Estudiante_Array registroEstudiantes) {
        this.vista = vista;
        this.registroEstudiantes = registroEstudiantes;
    }

    public void agregarEstudiante(String nombre, String direccion, String numero, Date fechaNacimiento) {
        try {
            int edad = calcularEdad(fechaNacimiento); // Calcular la edad
            String codigo = registroEstudiantes.generarCodigo(); // Generar el código automáticamente

            Estudiante estudiante = new Estudiante(codigo, nombre, direccion, numero, edad);
            registroEstudiantes.agregarEstudiante(estudiante);
            vista.agregarEstudianteATabla(estudiante);
            JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();  // Imprimir la excepción en la consola
            JOptionPane.showMessageDialog(null, "Error al agregar el estudiante.");
        }
    }

    public void eliminarEstudiante(String codigo) {
        Estudiante estudiante = registroEstudiantes.buscarEstudiantePorCodigo(codigo); // Usar el código en lugar del DNI
        if (estudiante != null) {
            registroEstudiantes.eliminarEstudiante(estudiante);
            vista.eliminarEstudianteDeTabla(codigo); // Asegúrate de que se elimine usando el código
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void modificarEstudiante(String codigo, String nombre, String direccion, String numero, Date fechaNacimiento) {
        int edad = calcularEdad(fechaNacimiento); // Calcular la edad a partir de la nueva fecha de nacimiento

        Estudiante estudiante = registroEstudiantes.buscarEstudiantePorCodigo(codigo);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setDireccion(direccion);
            estudiante.setNumero(numero);
            estudiante.setEdad(edad); // Actualizamos la edad

            registroEstudiantes.modificarEstudiante(estudiante);
            vista.modificarEstudianteEnTabla(estudiante);

            JOptionPane.showMessageDialog(null, "Estudiante modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public List<Estudiante> buscarEstudiantes(String valor) {
        List<Estudiante> estudiantesEncontrados = new ArrayList<>();

        for (Estudiante estudiante : registroEstudiantes.getEstudiantes()) {
            if (estudiante.getNombre().toLowerCase().contains(valor.toLowerCase())
                    || estudiante.getDireccion().toLowerCase().contains(valor.toLowerCase())
                    || estudiante.getNumero().toLowerCase().contains(valor.toLowerCase())
                    || estudiante.getCodigo().toLowerCase().contains(valor.toLowerCase())) {
                estudiantesEncontrados.add(estudiante);
            }
        }

        return estudiantesEncontrados;
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : registroEstudiantes.getEstudiantes()) {
            System.out.println(estudiante.getCodigo() + " - "
                    + estudiante.getNombre() + " - Dirección: "
                    + estudiante.getDireccion() + " - Teléfono: "
                    + estudiante.getNumero());
        }
    }

    private int calcularEdad(Date fechaNacimiento) {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);

        int edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.MONTH) < fechaNac.get(Calendar.MONTH)
                || (fechaActual.get(Calendar.MONTH) == fechaNac.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNac.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        return edad;
    }
}
