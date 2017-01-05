package javase09.t01;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.fail;
import static utils.Utils.getAbsoluteTestResourcePath;

public class ValidationTest {

    @Test
    public void isValid() throws IOException, SAXException{
        String xsdPath = getAbsoluteTestResourcePath("xml" + System.getProperty("file.separator") + "library.xsd");
        String xmlPath = getAbsoluteTestResourcePath("xml" + System.getProperty("file.separator") + "library.xml");
        File schemaFile = new File(xsdPath);
        Source xmlFile = new StreamSource(new File(xmlPath));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        validator.validate(xmlFile);
    }
}
