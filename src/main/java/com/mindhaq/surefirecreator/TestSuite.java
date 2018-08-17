package com.mindhaq.surefirecreator;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final String name;
    private int tests = 0;
    private int errors = 0;
    private int failures = 0;
    private int skipped = 0;

    private final List<TestCase> testCases = new ArrayList<>();

    public TestSuite(String name) {
        this.name = name;
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public String getName() {
        return name;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }
}
