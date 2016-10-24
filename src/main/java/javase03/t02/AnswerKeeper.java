package javase03.t02;

import java.util.*;


public class AnswerKeeper {
    private static HashMap<Locale,ResourceBundle> bundleMap = new HashMap<>();
    private static List<Locale> supportedLocaleList;
    private static Locale curLocale;



    static {
        supportedLocaleList = Arrays.asList(new Locale("ru"),new Locale("en"));
        supportedLocaleList.forEach(
                elem -> bundleMap.put(elem,ResourceBundle.getBundle("javase03.t02.bundles.AnswerBundle", elem))
        );
        curLocale = supportedLocaleList.get(0);
    }


    /**
     * Returns an answer to the question with the specified number.
     * @param questionNumber the number of the question
     * @return An answer to the question
     */
    public static String getAnswer(Integer questionNumber){
        return bundleMap.get(curLocale).getString(questionNumber.toString());
    }

    /**
     * Switch locale to the specified one.
     * @param locale new locale
     * @throws IllegalArgumentException if this bundle does not support the specified locale
     */
    public static void switchLocale(Locale locale) throws IllegalArgumentException{
        if (!supportedLocaleList.contains(locale))
            throw new IllegalArgumentException("Switch to illegal locale " + locale);
        curLocale = locale;
    }

    /**
     * Returns current locale.
     * @return locale which is used now
     */
    public static Locale getCurrentLocale(){
        return curLocale;
    }

    private static class AnswerBundle_en extends ListResourceBundle{
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

    private static class AnswerBundle_ru extends ListResourceBundle{
        private Object[][] contents = {
                {"1", "Соединённое королевство"},
                {"2", "Франция"},
                {"3", "Сингапур"},
                {"4", "Россия"}
        };

        @Override
        protected Object[][] getContents() {
            return contents;
        }
    }
}
