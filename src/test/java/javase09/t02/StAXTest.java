package javase09.t02;

import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static utils.Utils.getAbsoluteResourcePath;

public class StAXTest extends AbstractParseTest{

    @Test
    @Override
    public void parseTest() throws FileNotFoundException, XMLStreamException{
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream(getAbsoluteResourcePath("menu.xml"));
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
        MenuStAXParser parser = new MenuStAXParser();
        parser.parse(reader);
        actualFoodList = parser.getFoodList();
    }
}