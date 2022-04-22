package lesson8_workingWithFiles.homework;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseFilesTests {

    @Test
    void parsePdfTest() throws Exception {
        PDF pdf = new PDF(new File("src/test/resources/ezyzip.zipcertificate.pdf"));
        assertThat(pdf.numberOfPages).isEqualTo(1);
        assertThat(pdf.text).contains("Интерактивный тренажер по SQL");
    }

    @Test
    void parseCsvTest() throws Exception {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/ezyzip.ziplistOfPurchases.csv"));
        List<String[]> allRows = reader.readAll();
        assertThat(allRows.get(2)).contains("Сахар");
    }

    @Test
    void parseXlsTest() throws IOException {
        XLS xls = new XLS(new File("src/test/resources/ezyzip.zipCities.xlsx"));
        assertThat(xls.excel.getSheetAt(0)
                .getRow(3)
                .getCell(1)
                .getStringCellValue()).contains("Kazan");
    }
}


