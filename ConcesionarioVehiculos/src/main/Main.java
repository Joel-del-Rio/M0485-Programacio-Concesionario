/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import persistencia.FicheroVehiculos;
import vista.VentanaAlta;
import vista.VentanaPrincipal;

/**
 *
 * @author joeli
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FicheroVehiculos f = new FicheroVehiculos();
        f.folderCreate();
        
        VentanaPrincipal add = new VentanaPrincipal();
        add.setVisible(true);
        
    }
}
