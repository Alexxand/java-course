package javase03.t02.bundles;

import java.util.ListResourceBundle;


class AnswerBundle_en extends ListResourceBundle {
    private Object[][] contents = {
            {"1", "United Kingdom"},
            {"2", "France"},
            {"3", "Singapore"},
            {"4", "Russia"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
