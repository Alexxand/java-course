package javase09.t02.SAX;

import javase09.t02.Food;
import javase09.t02.Food.FoodBuilder;
import org.xml.sax.XMLFilter;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class MenuSaxHandler extends DefaultHandler {

        private List<Food> foodList = new ArrayList<Food>();
        private FoodBuilder parsingFoodBuilder;
        private StringBuilder text;

        public List<Food> getFoodList() {
            return foodList;
        }

        public void startDocument() throws SAXException {
            //System.out.println("Parsing started.");
        }



        public void endDocument() throws SAXException {
            //System.out.println("Parsing ended.");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);
            text = new StringBuilder();
            if (qName.equals("food")){
                parsingFoodBuilder = Food.builder();
                parsingFoodBuilder.id((Integer.parseInt(attributes.getValue("id"))));
            }

        }

        public void characters(char[] buffer, int start, int length) {
            text.append(buffer, start, length);
        }

        public void endElement(String uri, String localName, String qName)

                throws SAXException {

            switch(qName){
                case "name":
                    parsingFoodBuilder.name(text.toString());
                    break;
                case "price":
                    parsingFoodBuilder.price(Double.parseDouble(text.toString()));
                    break;
                case "description":
                    parsingFoodBuilder.description(text.toString());
                    break;
                case "calories":
                    parsingFoodBuilder.calories(Integer.parseInt(text.toString()));
                    break;
                case "food":
                    foodList.add(parsingFoodBuilder.build());
                    parsingFoodBuilder = null;
                    break;
            }

        }

        /*public void warning(SAXParseException exception) {

            System.err.println("WARNING: line " + exception.getLineNumber() + ": "

                    + exception.getMessage());

        }

        public void error(SAXParseException exception) {

            System.err.println("ERROR: line " + exception.getLineNumber() + ": "

                    + exception.getMessage());

        }

        public void fatalError(SAXParseException exception) throws SAXException {

            System.err.println("FATAL: line " + exception.getLineNumber() + ": "

                    + exception.getMessage());

            throw (exception);

        }*/

    }
