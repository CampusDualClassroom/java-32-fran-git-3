package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise32 {

    public static void main(String[] args) {
        // Generar la cadena a guardar
        String stringToSave = generateUserInputToSave();

        // Guardar la cadena en el archivo
        printToFile(stringToSave);
    }

    // Método que genera el texto que se guardará
    public static String generateStringToSave(String string) {
        return string; // Se retorna el string sin cambios.
    }

    // Método para generar la entrada del usuario
    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        // Utiliza Utils para leer el input del usuario hasta que esté vacío
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    // Método que imprime el texto al archivo
    public static void printToFile(String string) {
        String filePath = "src/main/resources/data.txt"; // Ajustamos la ruta del archivo según el test

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Escribimos la cadena en el archivo
            writer.write(generateStringToSave(string));
            System.out.println("Texto guardado en el archivo.");
        } catch (IOException e) {
            // Si ocurre un error, se imprime el mensaje de error
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
