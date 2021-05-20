package com.tms.docs_organize.filler;

import java.io.*;
import java.util.Random;

/**
 * Класс, служащий для записи в файл сгенерированных номеров документов
 */
public class DocNumWriter {
    public static void main(String[] args) {
        Random r = new Random();
        try(FileWriter fw = new FileWriter(new File("docs.txt"))) {
            for(int j = 0; j < 2000; j++){
                fw.write(DocNumGenerator.generateDocNum(10+r.nextInt(10))+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
