/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author joeli
 */
public class FicheroVehiculos {

    static List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    static String separator = File.separator;

    static String ubi = System.getProperty("user.dir");

    static File carpeta = new File(ubi + separator + "datos");

    static File archivo = new File(ubi + separator + "datos" + separator + "vehiculos.txt");

    public static void folderCreate() {

        try {

            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void guardar(List<Vehiculo> vehiculos) {

        try {

            FileWriter fw = new FileWriter(archivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Vehiculo v : vehiculos) {

                bw.write(v.toString());
                bw.newLine();
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static List<Vehiculo> cargar() {

        try {

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] atributo = line.split(";");
                Vehiculo v = new Vehiculo(atributo[0], atributo[1], atributo[2], Double.parseDouble(atributo[3]), atributo[4]);
                vehiculos.add(v);    
            }
            br.close();

        } catch (IOException a) {
            System.out.println("Error");
        }
        return vehiculos;
    }
}
