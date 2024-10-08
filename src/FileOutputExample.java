import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputExample {
    public static void main(String[] args) {
       //Constructor para OutputStream
        try {
            OutputStream fos = new FileOutputStream("archivo.txt");

            //Escribir en el fichero
            fos.write(65);
            fos.write(105);
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }
    }
}
