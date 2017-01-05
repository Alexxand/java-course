package javase09.t02;

import javax.xml.stream.XMLInputFactory;
import javase09.t02.Food.FoodBuilder;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuStAXParser {
    private List<Food> foodList = null;

    public void parse(XMLStreamReader reader) throws XMLStreamException {
        foodList = new ArrayList<>();
        FoodBuilder parsingFoodBuilder = null;
        String parsingElementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    parsingElementName = reader.getLocalName();
                    if (parsingElementName.equals("food")){
                        parsingFoodBuilder = Food.builder();
                        int id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                        parsingFoodBuilder.id(id);
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (parsingElementName) {
                        case "name":
                            parsingFoodBuilder.name(text);
                            break;
                        case "price":
                            parsingFoodBuilder.price(Double.parseDouble(text.replace("$","")));
                            break;
                        case "description":
                            parsingFoodBuilder.description(text);
                            break;
                        case "calories":
                            parsingFoodBuilder.calories(Integer.parseInt(text));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:

                    parsingElementName = reader.getLocalName();
                    if (parsingElementName.equals("food"))
                        foodList.add(parsingFoodBuilder.build());
            }
        }
    }

    public List<Food> getFoodList(){
        return foodList;
    }
}
