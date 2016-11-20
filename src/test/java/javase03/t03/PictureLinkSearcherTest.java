package javase03.t03;

import org.junit.Test;
import utils.Utils;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.getAbsoluteResourcePath;


public class PictureLinkSearcherTest {

    @Test
    public void ifLinksGoConsequentiallyTest() throws IOException{
        Reader reader = new InputStreamReader(
                new FileInputStream(getAbsoluteResourcePath("Java.SE.03.Information handling_task_attachment.html")),
                "windows-1251"
        );
        PictureLinkSearcher pictureLinkSearcher = new PictureLinkSearcher(reader);
        assertEquals(false,pictureLinkSearcher.ifLinksGoConsequentially());
    }

    @Test
    public void getSentencesWithPictureLinksTest() throws IOException{
        Reader reader = new InputStreamReader(
                new FileInputStream(getAbsoluteResourcePath("Java.SE.03.Information handling_task_attachment.html")),
                "windows-1251");
        PictureLinkSearcher pictureLinkSearcher = new PictureLinkSearcher(reader);
        assertEquals(false,pictureLinkSearcher.ifLinksGoConsequentially());
        List<String> sentenceList = pictureLinkSearcher.getSentencesWithPictureLinks();
        Pattern pattern = Pattern.compile("([Рр]ис. |[Нн]а рисунке )[\\d]+");
        for (String sentence : sentenceList){
            Matcher matcher = pattern.matcher(sentence);
            assertTrue(matcher.find());
        }
    }
}
