import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputExample {
    public static void main(String[] args) {
       //Constructor para OutputStream
        printCharacters();
        printCharactersFromArray();
    }



    private static void printCharacters() {
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

    private static void printCharactersFromArray() {
        try (OutputStream fos = new FileOutputStream("archivo.txt")) {

            String message = "Hello there!\n";
            byte[] messageInBytes = message.getBytes();

            fos.write(messageInBytes);
        }
         catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }


    }
}
