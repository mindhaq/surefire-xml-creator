package com.mindhaq.surefirecreator;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

public class TestSuiteXMLWriter implements AutoCloseable {
    private final XMLStreamWriter writer;

    public TestSuiteXMLWriter(Path path) throws IOException, XMLStreamException {
        var outputFactory = XMLOutputFactory.newInstance();
        var outputStream = new BufferedOutputStream(Files.newOutputStream(path, CREATE, WRITE, TRUNCATE_EXISTING));

        writer = outputFactory.createXMLStreamWriter(outputStream);
        writer.writeStartDocument();
    }

    @Override
    public void close() throws Exception {
        writer.writeEndDocument();
        writer.close();
    }

    public void write(TestSuite testSuite) throws XMLStreamException {
        writer.writeStartElement("testsuite");
        writer.writeAttribute("name", testSuite.getName());
        writer.writeAttribute("tests", Integer.toString(testSuite.getTests()));
        writer.writeAttribute("errors", Integer.toString(testSuite.getErrors()));
        writer.writeAttribute("skipped", Integer.toString(testSuite.getSkipped()));
        writer.writeAttribute("failures", Integer.toString(testSuite.getFailures()));

        for (TestCase testCase: testSuite.getTestCases()) {
            write(testCase);
        }

        writer.writeEndDocument();
    }

    private void write(TestCase testCase) throws XMLStreamException {
        writer.writeStartElement("testcase");
        writer.writeAttribute("name", testCase.getName());
        writer.writeAttribute("time", testCase.getTime());
        writer.writeEndElement();
    }
}
