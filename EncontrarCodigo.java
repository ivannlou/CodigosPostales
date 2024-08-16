import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class EncontrarCodigo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ingresa el codigo postal");
            return;
        }

        String path = "C:/Users/DELL/Desktop/DES2/codigos_postales.csv";
        HashMap<String, ArrayList<String>> mapaAsentamientos = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;


            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    String codigoPostal = values[0].trim();
                    String asentamiento = values[1].trim();

                    mapaAsentamientos
                            .computeIfAbsent(codigoPostal, k -> new ArrayList<>())
                            .add(asentamiento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String codigoPostal : args) {
            ArrayList<String> asentamientos = mapaAsentamientos.get(codigoPostal);

            if (asentamientos != null) {
                System.out.println("Asentamientos para el cdigo postal " + codigoPostal + ":");
                for (String asentamiento : asentamientos) {
                    System.out.println("- " + asentamiento);
                }
            } else {
                System.out.println("No se encontraron asentamientos para el codigo postal " + codigoPostal);
            }
        }
    }
}
