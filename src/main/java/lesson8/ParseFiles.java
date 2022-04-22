package lesson8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ParseFiles {
    public static void main(String[] args) throws Exception {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("src/test/resources/ezyzip.zip"))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName(); // получим название файла
                System.out.println(name);

                // распаковка
                FileOutputStream fout = new FileOutputStream("src/test/resources/ezyzip.zip" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
    }
}


