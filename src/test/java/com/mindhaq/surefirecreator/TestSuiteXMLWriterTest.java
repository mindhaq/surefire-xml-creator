package com.mindhaq.surefirecreator;

import org.junit.Test;
import org.xmlunit.assertj.XmlAssert;
import org.xmlunit.builder.Input;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.nio.file.Paths;
import java.time.Instant;

import static com.mindhaq.surefirecreator.SurefireXmlCreator.exampleTestSuite;
import static java.nio.file.Files.delete;
import static org.assertj.core.api.Assertions.assertThat;

public class TestSuiteXMLWriterTest {

    @Test
    public void creates_valid_file() throws Exception {
        // given
        var filePath = "/tmp/testsuite_" + Instant.now() + ".xml";
        var path = Paths.get(filePath);
        var testSuite = exampleTestSuite(10);

        // when
        try (var writer = new TestSuiteXMLWriter(path)) {
            writer.write(testSuite);
        }
        var xmlSource = Input.fromFile(filePath).build();

        // then
        assertThat(path).exists();

        var schema = SchemaFactory.newDefaultInstance().newSchema(new StreamSource(SurefireXmlCreator.class.getResourceAsStream("surefire-test-report.xsd")));
        XmlAssert.assertThat(xmlSource).isValidAgainst(schema);

        // after
        delete(path);
    }

}
