package javase09.t02;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.*;

import static utils.Utils.getAbsoluteResourcePath;

public class DOMTest extends AbstractParseTest{
    @Test
    @Override
    public void parseTest() throws IOException, SAXException, XMLStreamException {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(new FileInputStream(getAbsoluteResourcePath("menu.xml"))));
        MenuDomParser customParser = new MenuDomParser();
        customParser.parse(parser);
        actualFoodList = customParser.getFoodList();
    }
}
