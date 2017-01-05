package javase09.t02.SAX;

import javase09.t02.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class StringFilter extends XMLFilterImpl {

    public StringFilter(XMLReader parent){
        super(parent);
    }

    private boolean withinPrice = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("price")) {
            withinPrice = true;
        }
        super.startElement(uri,localName,qName,attributes);
    }

    public void characters(char[] buffer, int start, int length) throws SAXException {

        String tempString = new String(buffer,start,length);

        tempString = tempString.replace("\n","").trim();
        if (withinPrice) {
            tempString = tempString.replace("$","");
        }
        super.characters(tempString.toCharArray(),0,tempString.length());
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("price")) {
            withinPrice = false;
        }
        super.endElement(uri,localName,qName);
    }
}
