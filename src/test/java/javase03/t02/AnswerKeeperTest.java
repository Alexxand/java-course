package javase03.t02;


import javase03.t02.bundles.AnswerBundle_en;
import javase03.t02.bundles.AnswerBundle_ru;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class AnswerKeeperTest {
    String nameBundleClass = "javase03.t02.bundles.AnswerBundle";
    String nameBundleFile = "AnswerBundle";


    @Test
    public void getAnswersInRussian(){
        AnswerKeeper keeper = new AnswerKeeper(nameBundleClass);
        assertEquals("Соединённое Kоролевство",keeper.getAnswer(1));
        assertEquals("Франция",keeper.getAnswer(2));
        assertEquals("Сингапур",keeper.getAnswer(3));
        assertEquals("Россия",keeper.getAnswer(4));
    }

    @Test
    public void changeLocale(){
        AnswerKeeper keeper = new AnswerKeeper(nameBundleClass);
        keeper.switchLocale(new Locale("en"));
        assertEquals(new Locale("en"),keeper.getCurrentLocale());
    }

    @Test
    public void getAnswersInEnglish(){
        AnswerKeeper keeper = new AnswerKeeper(nameBundleClass);
        keeper.switchLocale(new Locale("en"));
        assertEquals("United Kingdom",keeper.getAnswer(1));
        assertEquals("France",keeper.getAnswer(2));
        assertEquals("Singapore",keeper.getAnswer(3));
        assertEquals("Russia",keeper.getAnswer(4));
    }

    @Test
    public void getAnswersInRussianUsingResourcesFromFile(){
        AnswerKeeper keeper = new AnswerKeeper(nameBundleFile);
        assertEquals("Соединённое Королевство",keeper.getAnswer(1));
        assertEquals("Франция",keeper.getAnswer(2));
        assertEquals("Сингапур",keeper.getAnswer(3));
        assertEquals("Россия",keeper.getAnswer(4));
    }

    @Test
    public void getAnswersInEnglishUsingResourcesFromFile(){
        AnswerKeeper keeper = new AnswerKeeper(nameBundleFile);
        keeper.switchLocale(new Locale("en"));
        assertEquals("United Kingdom",keeper.getAnswer(1));
        assertEquals("France",keeper.getAnswer(2));
        assertEquals("Singapore",keeper.getAnswer(3));
        assertEquals("Russia",keeper.getAnswer(4));
    }
}
