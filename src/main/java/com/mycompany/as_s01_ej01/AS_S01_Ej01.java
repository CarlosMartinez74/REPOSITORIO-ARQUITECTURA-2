package com.mycompany.as_s01_ej01;

import Vista.VistaRegistro;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AS_S01_Ej01 {

    public static void main(String[] args) {
        try {
            // Establecer el look and feel JTattoo McWin
            UIManager.setLookAndFeel(new McWinLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();  // Manejar la excepción
        }

        // Crear e iniciar la interfaz gráfica (GUI)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia del formulario de Registro de Estudiantes
                VistaRegistro formulario = new VistaRegistro();
                // Hacer visible el formulario
                formulario.setVisible(true);
            }
        });
    }
}
