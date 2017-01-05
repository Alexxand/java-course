package javase09.t02;

import javase09.t02.SAX.MenuSaxHandler;
import javase09.t02.SAX.StringFilter;
import org.junit.Test;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXTest extends AbstractParseTest{

    @Test
    @Override
    public void parseTest() throws SAXException, IOException{
        XMLReader reader = XMLReaderFactory.createXMLReader();
        XMLFilter priceFilter = new StringFilter(reader);
        MenuSaxHandler handler = new MenuSaxHandler();
        priceFilter.setContentHandler(handler);
        priceFilter.parse(new InputSource(getClass().getClassLoader().getResourceAsStream("menu.xml")));
        actualFoodList = handler.getFoodList();

    }
}
