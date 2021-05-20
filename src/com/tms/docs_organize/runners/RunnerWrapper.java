package com.tms.docs_organize.runners;

import com.tms.docs_organize.checker.DocsChecker;
import com.tms.docs_organize.console_data.ConsoleData;

public class RunnerWrapper {
    public static void go(){
        String[] files = ConsoleData.getConsoleData();
        DocsChecker.checkDocs(files[0],files[1],files[2]);
        System.out.println("Completed");
    }
}
