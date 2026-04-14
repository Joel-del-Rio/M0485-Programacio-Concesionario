/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Vehiculo;
import persistencia.FicheroVehiculos;

/**
 *
 * @author joeli
 */
public class Concesionario {

    private static List<Vehiculo> vehiculos = FicheroVehiculos.cargar();

    public static void insertarVehiculo(Vehiculo v) {

        if (comprove(v)) {
            vehiculos.add(v);
            FicheroVehiculos.guardar(vehiculos);
            JOptionPane.showMessageDialog(null, "Guardado Correctamente", "Aviso", 1);
        } else {
            JOptionPane.showMessageDialog(null, "La matricula ya esta registrada", "Error", 1);
        }
    }

    public static Vehiculo buscarVehiculo(String matricula) {

        Vehiculo vehiculo = null;
        for (Vehiculo ve : vehiculos) {
            if (ve.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println(matricula);
                vehiculo = ve;
                break;
            }
        }
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "La matricula introducida no existe", "Error", 1);
        }
        return vehiculo;
    }

    public static void eliminarVehiculo(String matricula) {

        for (Vehiculo ve : vehiculos) {
            if (ve.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculos.remove(ve);
                FicheroVehiculos.guardar(vehiculos);
                break;
            }
        }
    }

    public static List<Vehiculo> listarVehiculos() {

        return Concesionario.vehiculos;
    }

    public static boolean comprove(Vehiculo v) {

        boolean comprove = true;

        for (Vehiculo ve : vehiculos) {
            if (ve.getMatricula().equals(v.getMatricula())) {
                comprove = false;
                break;
            }
        }
        return comprove;
    }

}
