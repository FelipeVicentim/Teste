package com.wsteste.atividade01.CSV;

import com.wsteste.atividade01.model.Cars;
import com.wsteste.atividade01.model.Factories;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"CAR_ID", "MODELO", "ANO", "COMBUSTIVEL", "NUM PORTAS", "VALOR FIPE",
            "COR"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Cars> csvToCars(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Cars> carsList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Cars cars = new Cars(
                        Long.parseLong(csvRecord.get("CAR_ID")),
                        csvRecord.get("MODELO"),
                        Integer.parseInt(csvRecord.get("ANO")),
                        csvRecord.get("COMBUSTIVEL"),
                        Integer.parseInt(csvRecord.get("NUM PORTAS")),
                        Double.parseDouble(csvRecord.get("VALOR FIPE")),
                        csvRecord.get("COR")
                );

                carsList.add(cars);

            }

            return carsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream carsToCSV(List<Cars> carsList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

            for (Cars cars : carsList) {
                List<String> data = Arrays.asList(
                        String.valueOf(cars.getCar_id()),
                        cars.getCar_model(),
                        String.valueOf(cars.getCar_year()),
                        cars.getCar_fuel(),
                        String.valueOf(cars.getCar_doors()),
                        String.valueOf(cars.getCar_cost()),
                        cars.getCar_color()
                );

            csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
