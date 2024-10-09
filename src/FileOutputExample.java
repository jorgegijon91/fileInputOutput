import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOutputExample {
    public static void main(String[] args) {
        //Constructor para OutputStream
        // printCharacters();
        // printCharactersFromArray();
        //Imprimir desde loop
        // printFromLoop();
        //Leer un caracter
        //readCharacter();
       //readCharacterWithLoop();
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

            String message = "Hola\n" + "Adios Pepe, nos vemos luego";
            byte[] messageInBytes = message.getBytes();

            //flush()-> Enviar los datos al archivo
            //Mostrar Hola y Pepe nada mas
            fos.write(messageInBytes, 0, 5);
            fos.write(messageInBytes, 11, 4);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo");
        }


    }

    private static void printFromLoop() {
        try (OutputStream fos = new FileOutputStream("archivo.txt")) {
            char numero = '0';
            System.out.println((int) numero);
            char salto = '\n';
            fos.write((int) salto);
            //Imprimir de 0 a 9
            for (int i = 48; i <= 57; i++) {
                fos.write(i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo");
        }
    }

    private static void readCharacter() {
        try (InputStream fis = new FileInputStream("archivo.txt")) {

            //Leer un byte
            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }

    }
    private static void readCharacterWithLoop() {

        try(InputStream fis = new FileInputStream("archivo.txt")) {
            //Crear un array de bytes
            byte[] bytes = new byte[4096];
           int bytesLeidos =  fis.read(bytes, 100, 8);
           System.out.println("Bytes leidos: " + bytesLeidos);

           //Imprimir los caracteres leídos
            for(int i=0; i< bytesLeidos; i++){
                System.out.print((char)bytes[i]);
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }

    }


}
