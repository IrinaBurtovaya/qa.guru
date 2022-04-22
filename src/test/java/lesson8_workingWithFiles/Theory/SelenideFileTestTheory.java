package lesson8_workingWithFiles.Theory;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFileTestTheory {

    @Test
    void selenideDownloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download(); //абстракция над путем
       /* try (InputStream is = new FileInputStream(downloadedFile)) { //определяем скачанный файл в стрим для дальнейшего чтения
       // конструкция try (InputStream is = new FileInputStream(downloadedFile)) сама закроет стрим
            byte[] fileContent = is.readAllBytes(); //записываем файл в байты для чтения
            String strContent = new String(fileContent, StandardCharsets.UTF_8);//читаем файл в нужной кодировке
            assertThat(strContent).contains("JUnit 5");
        }*/

//        2й способ скачивания
        String readString = Files.readString(downloadedFile.toPath(), StandardCharsets.UTF_8);
        assertThat(readString).contains("JUnit 5");
    }

    @Test
    void uploadSelenideTest() {
        Selenide.open("https://the-internet.herokuapp.com/upload ");
        $("input[type='file']").uploadFromClasspath("1.txt");
        $("#file-submit").click();
        $("div.example").shouldHave(Condition.text("File Uploaded!"));
        $("#uploaded-files").shouldHave(Condition.text("1.txt"));
    }
}
