package com.tms.docs_organize.console_data;

import java.util.Scanner;

public class ConsoleData {
    public static String[] getConsoleData(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter output file: ");
        String file1 = s.nextLine();

        System.out.print("Enter input file for correct docs: ");
        String file2 = s.nextLine();

        System.out.print("Enter input file for incorrect docs: ");
        String file3 = s.nextLine();

        return new String[]{file1, file2, file3};
    }
}
