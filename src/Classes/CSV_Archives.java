package Classes;

import java.io.*;
import java.util.ArrayList;
import com.csvreader.CsvWriter;

public class CSV_Archives {
    protected String[] rows = null; // Partes divididas de la línea


    /*Metodo para crear un archivo CSV*/
    public void crearArchivoCSV(ArrayList<Contacts> ContactList) throws IOException {
        try {
            CsvWriter csvWriter = new CsvWriter("contactos.csv"); // Nombre del archivo

            for (Contacts contact : ContactList) {
                String[] sContacts = contact.toArray(); // Convierte el contacto en un arreglo de strings
                csvWriter.writeRecord(sContacts); // Escribe cada contacto en el archivo
            }
            csvWriter.close();
            System.out.println("Archivo CSV creado exitosamente.");
        } catch (IOException ex) {
            System.err.println("ERROR: No se pudo crear el archivo CSV.");
            ex.printStackTrace();
        }
    }

    /* Metodo para leer un archivo CSV e importar contactos a la lista */
    public void leerArchivo(String nombreArchivo, ArrayList<Contacts> ContactList) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            // Línea leída desde el archivo
            String line;
            while ((line = lector.readLine()) != null) {
                rows = line.split(","); /*Separador de comas*/
                if (rows.length == 8) { // Validación de que la línea tenga todos los campos necesarios
                    try {
                        int id = Integer.parseInt(rows[0].trim());
                        int telefono = Integer.parseInt(rows[4].trim());
                        Contacts contact = new Contacts(id, rows[1].trim(), rows[2].trim(), rows[3].trim(),
                                telefono, rows[5].trim(), rows[6].trim(), rows[7].trim());
                        ContactList.add(contact); // Agrega el contacto a la lista global
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir un dato a número en línea: " + line);
                    }
                } else {
                    System.err.println("Línea mal formateada: " + line);
                }
            }
            System.out.println("Archivo CSV leído exitosamente.");
        } catch (IOException e) {
            System.err.println("ERROR: No se pudo leer el archivo.");
            e.printStackTrace();
        }
    }
}