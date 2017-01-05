package javase09.t02;

import javase09.t02.Food.FoodBuilder;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuDomParser {
    private List<Food> foodList = null;

    public void parse(DOMParser parser) throws XMLStreamException {
        foodList = new ArrayList<>();

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        NodeList foodNodes = root.getElementsByTagName("food");

        for (int i=0; i < foodNodes.getLength(); ++i){
            Element foodElement = (Element) foodNodes.item(i);
            FoodBuilder foodBuilder = Food.builder();

            String attrId = foodElement.getAttribute("id");
            foodBuilder.id(Integer.parseInt(attrId));

            Element elemName = getSingleChild(foodElement,"name");
            foodBuilder.name(elemName.getTextContent());

            Element elemPrice = getSingleChild(foodElement,"price");
            foodBuilder.price(Double.parseDouble(elemPrice.getTextContent().replace("$","")));

            Element elemDescription = getSingleChild(foodElement,"description");
            foodBuilder.description(elemDescription.getTextContent().trim());

            Element elemCalories = getSingleChild(foodElement,"calories");
            foodBuilder.calories(Integer.parseInt(elemCalories.getTextContent()));

            foodList.add(foodBuilder.build());
        }
    }

    private static Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    public List<Food> getFoodList(){
        return foodList;
    }
}
