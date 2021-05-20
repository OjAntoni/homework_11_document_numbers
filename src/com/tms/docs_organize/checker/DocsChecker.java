package com.tms.docs_organize.checker;

import com.tms.docs_organize.checker_exceptions.DocException;
import com.tms.docs_organize.checker_exceptions.LengthException;

import java.io.*;

public class DocsChecker {
    /**
     * Метод принимает три пути к файлам, проверяет и записывает,
     * распределяя нужные номера документов в нужные файлы
     * @param file1 файл откуда требуется прочитать номера документов
     * @param file2 файл куда пойдут правильные номера
     * @param file3 файл куда пойдут номера не подходящие
     */
    public static void checkDocs(String file1, String file2, String file3){
        File fileFromX = new File(file1);
        File fileToX =  new File(file2);
        File garbageFileX = new File(file3);
        if(fileFromX.isDirectory()){
            System.out.println("Expected path to file. Provided directory path: "+file1);
            return;
        }
        if(!fileFromX.exists()){
            System.out.println("Source file doesn't exist.");
            return;
        }
        if(fileToX.isDirectory()){
            System.out.println("Expected path to file. Provided directory path: "+file2);
            return;
        }
        if(garbageFileX.isDirectory()){
            System.out.println("Expected path to file. Provided directory path: "+file3);
            return;
        }

        try (BufferedReader fileFrom =new BufferedReader(new FileReader(fileFromX));
             BufferedWriter fileTo = new BufferedWriter(new FileWriter(fileToX));
             BufferedWriter  garbageFile = new BufferedWriter(new FileWriter(garbageFileX)))
        {
            String num;
            while ((num = fileFrom.readLine())!=null){
                try{
                    NumChecker.check(num);
                    fileTo.write(num);
                    fileTo.newLine();
                } catch ( DocException | LengthException e) {
                    garbageFile.write(String.format("%-40s%-22s%-21s", num, ":", e.getMessage()));
                    garbageFile.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
