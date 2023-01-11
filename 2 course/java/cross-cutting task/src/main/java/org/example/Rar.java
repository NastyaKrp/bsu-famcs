package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Rar {
    public static void rArch() throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output.rar"));
        FileInputStream fileInputStream = new FileInputStream("out_file.json");
        ZipEntry zipEntry = new ZipEntry("out_file.json");
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(fileInputStream.readAllBytes());
        zipOutputStream.closeEntry();
        fileInputStream = new FileInputStream("out.xml");
        zipEntry = new ZipEntry("out.xml");
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(fileInputStream.readAllBytes());
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }
}
