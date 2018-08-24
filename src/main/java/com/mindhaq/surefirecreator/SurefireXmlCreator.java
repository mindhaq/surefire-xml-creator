package com.mindhaq.surefirecreator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;

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

        print("Creating testsuite");
        var testSuite = exampleTestSuite(1_000_000);
        var testSuiteXMLWriter = new TestSuiteXMLWriter(Paths.get(output, "TEST-com.mindhaq.surefirecreator.BigExample.xml"));
        testSuiteXMLWriter.write(testSuite);
        print("Finished.");

        Files.copy(Paths.get("src/main/resources/com/mindhaq/surefirecreator/TEST-com.mindhaq.surefirecreator.Example.xml"), Paths.get(output, "TEST-com.mindhaq.surefirecreator.Example.xml"), REPLACE_EXISTING);
    }

    public static TestSuite exampleTestSuite(int numberOfTestCases) {
        var testSuite = new TestSuite("com.mindhaq.surefirecreator.Example");

        for (int i = 0; i < numberOfTestCases; i++) {
            TestCase testCase = new TestCase("Testcase #" + i, "0.01");
            testCase.setClassName("com.mindhaq.surefirecreator.Example");
            testSuite.addTestCase(testCase);
        }

        return testSuite;
    }

    private static void print(Object o) {
        System.out.println("" + Instant.now() + ": " + o);
    }
}
