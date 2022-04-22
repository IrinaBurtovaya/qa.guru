package lesson8_workingWithFiles.Theory;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTestTheory {

    @Disabled
    @Test
    void parsePdfTest() throws Exception {
        Selenide.open("");
        File pdfDownload = $(byText("PDF download")).download();
        PDF pdf = new PDF(pdfDownload);
        assertThat(pdf.author).isEqualTo("Marc");
    }

    @Disabled
    @Test
    void parseXlsTest() throws Exception {
        Selenide.open("");
        File xlsDownload = $("").download(); // скачали
        XLS xls = new XLS(xlsDownload); // преобразовали в xls
        assertThat(xls.excel.getSheetAt(0)
                .getRow(10)
                .getCell(1)
                .getStringCellValue()).contains("");
    }

    @Disabled
    @Test
        //csv читаем не как байты, а как набор символов
    void parseCsvTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();// 1й способ загрузки с помощью ClassLoader
       /*2й способ загрузки с помощью ClassLoader, если находить в статическом классе типа BeforeAll,
       где нет не статического метода getClass
        ClassLoader classLoader = FilesParsingTestTheory.class.getClassLoader(); */
        try (InputStream is = classLoader.getResourceAsStream("");
             CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> content = csvReader.readAll();
            assertThat(content.get(0)).contains("");
        }
    }

    @Disabled
    @Test
    void parseZipTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isEqualTo("");
            }
        }
    }

    @Disabled
    @Test
    void parseJsonTest() throws Exception {
        Gson gson = new Gson();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("")) {
            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            assertThat(jsonObject.get("").getAsJsonObject().get("")).isEqualTo("");
        }
    }

}
