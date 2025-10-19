package ArquitecturasWeb.utils;



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectorCSV {

    public static Iterable<CSVRecord> leerCSV(String ruta) {
        try {
            InputStream inputStream = LectorCSV.class.getClassLoader().getResourceAsStream(ruta);
            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo CSV en resources: " + ruta);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            CSVParser parser = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(reader);

            return parser.getRecords();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + ruta, e);
        }
    }
}
