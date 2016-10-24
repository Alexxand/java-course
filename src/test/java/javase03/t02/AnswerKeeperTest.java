package javase03.t02;


import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class AnswerKeeperTest {
    @Test
    public void getAnswersInRussia(){
        assertEquals("Соединённое королевство",AnswerKeeper.getAnswer(1));
        assertEquals("Франция",AnswerKeeper.getAnswer(2));
        assertEquals("Сингапур",AnswerKeeper.getAnswer(3));
        assertEquals("Россия",AnswerKeeper.getAnswer(4));
    }

    @Test
    public void changeLocale(){
        AnswerKeeper.switchLocale(new Locale("en"));
        assertEquals(new Locale("en"),AnswerKeeper.getCurrentLocale());
    }

    @Test
    public void getAnswersInEnglish(){
        AnswerKeeper.switchLocale(new Locale("en"));
        assertEquals("United Kingdom",AnswerKeeper.getAnswer(1));
        assertEquals("France",AnswerKeeper.getAnswer(2));
        assertEquals("Singapore",AnswerKeeper.getAnswer(3));
        assertEquals("Russia",AnswerKeeper.getAnswer(4));
    }
}
