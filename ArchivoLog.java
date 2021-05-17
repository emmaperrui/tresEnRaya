/**
 * Programa que simula un juego de 3 en raya.
 * @author Emma
 * @version (1)
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchivoLog {

    private File file;
    private Writer output;
    
    /**
     * M�todo para inicializar el log.
     */
    public ArchivoLog() {
        String fecha = new SimpleDateFormat("ddMMyyyy-HHmm").format(new Date());
        String fileName = fecha.concat("-log.txt");
        //String fecha = new SimpleDateFormat("ddMMyyy-HHmm").format(new Date());
        //String fileName = fecha.concat("-log.txt");
        file = new File(fileName);
    }
    
    
    public ArchivoLog(File file) {
        this.file = file;
    }
    
    /**
     * M�todo para obtener el file.
     * @return file.
     */
    public File getFile() {
        return file;
    }
    
    /**
     * M�todo para settear el file.
     * @param file.
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     * M�todo para imprimir informaci�n del log. Usamos try catch para el control de errores.
     * @param imprimibleEnconsola Boolena para ver si imprimimos teclado o no.
     * @param line String.
     */
    public void addLine(boolean imprimibleEnconsola, String line) {
        if (imprimibleEnconsola) {
            System.out.println(line);
        }
        try {
            String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
            output = new BufferedWriter(new FileWriter(file, true));
            output.append("\n" + fecha + " " + line);
            output.close();
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error a la hora de insertar informaci�n en el archivo " + file.getName());
        }
    }
    
    /**
     * M�todo para imprimir informaci�n del log. Usamos try catch para el control de errores.
     * @param line String.
     */
    public void addTablero(String line) {
        System.out.println(line);
        try {
            output = new BufferedWriter(new FileWriter(file, true));
            output.append("\n" + line);
            output.close();
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error a la hora de insertar informaci�n en el archivo " + file.getName());
        }
    }
}
