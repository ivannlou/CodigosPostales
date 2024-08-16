import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "C:/Users/DELL/Desktop/DES2/codigos_postales.csv";
        String line;
        int urbanos = 0;
        int rurales = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));


            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    String tipo = values[2].trim().toLowerCase();

                    if (tipo.equals("urbano")) {
                        urbanos++;
                    } else if (tipo.equals("rural")) {
                        rurales++;
                    }
                }
            }

            System.out.println("Número de asentamientos urbanos: " + urbanos);
            System.out.println("Número de asentamientos rurales: " + rurales);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
