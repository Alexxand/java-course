
package javase03.t02;

import java.io.IOException;
import java.util.*;


public class AnswerKeeper {
    private HashMap<Locale,ResourceBundle> bundleMap = new HashMap<>();
    private List<Locale> supportedLocaleList = Arrays.asList(new Locale("ru"),new Locale("en"));;
    private Locale curLocale = supportedLocaleList.get(0);;

    /*public AnswerKeeper(Class<? extends ListResourceBundle> clazz){
        initMap(clazz.getName().split("_")[0]);
    }

    public AnswerKeeper(String filename){
        initMap(filename.split("[._]")[0]);
    }*/

    public AnswerKeeper(String bundleName){
        supportedLocaleList.forEach(
                elem -> bundleMap.put(elem,ResourceBundle.getBundle(bundleName, elem))
        );
    }


    /**
     * Returns an answer to the question with the specified number.
     * @param questionNumber the number of the question
     * @return An answer to the question
     */
    public String getAnswer(Integer questionNumber){
        return bundleMap.get(curLocale).getString(questionNumber.toString());
    }

    /**
][   * Switch locale to the specified one.
'?   * @param locale new locale
     * @throws IllegalArgumentException if this bundle does not support the specified locale
     */
    public void switchLocale(Locale locale) throws IllegalArgumentException{
        if (!supportedLocaleList.contains(locale))
            throw new IllegalArgumentException("Switch to illegal locale " + locale);
        curLocale = locale;
    }

    /**
     * Returns current locale.
     * @return locale which is used now
     */
    public Locale getCurrentLocale(){
        return curLocale;
    }
}
