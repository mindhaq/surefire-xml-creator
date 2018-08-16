package com.mindhaq.surefirecreator;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class SurefireXmlCreator {
    public static void main(String[] args) throws Exception {
        print("Running " + SurefireXmlCreator.class.getSimpleName());

        print("Arguments:");
        for (String arg : args) {
            print(arg);
        }
        print("");

        print("System:");
        System.getProperties()
                .keySet()
                .stream()
                .peek(entry -> print(entry));

        var output = args[0] + "/surefire-reports";

        Files.copy(Paths.get("/Users/rue/code/public/surefire-xml-creator/src/main/resources/com/mindhaq/surefirecreator/TEST-com.mindhaq.surefirecreator.Example.xml"), Paths.get(output, "TEST-com.mindhaq.surefirecreator.Example.xml"), REPLACE_EXISTING);
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
