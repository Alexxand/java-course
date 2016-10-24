package javase03.t02.bundles;

import java.util.ListResourceBundle;


public class AnswerBundle_ru extends ListResourceBundle {
    private Object[][] contents = {
            {"1", "Соединённое Kоролевство"},
            {"2", "Франция"},
            {"3", "Сингапур"},
            {"4", "Россия"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
