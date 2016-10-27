package javase03.t03;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alexmich on 26.10.16.
 */
public class PictureLinkSearcherTest {
    private static String s = "<div>Короткие силовые связи между ближайшими ядрами атомов углерода образуют правильные шестиугольники – периметры магнетонов, дальние силовые связи индуцируют коллективную структуру магнетонов. Короткие и дальние силовые связи едины и неразделимы в структурах магнетонов, определяют химические свойства атомов углерода в молекулах графита. Почему чешуйку графита (Рис. 18 и 21) необходимо называть плоской раскрытой молекулой графита С<sub>54</sub>? Плоские, раскрытые молекулы графита С<sub>54</sub> (Рис. 21) в особых внешних условиях «сворачиваются» в закрытые нейтральные молекулы графита С<sub>60</sub> – фуллерены (Рис. 22). По количеству атомов углерода, чешуйка графита (рис. 21) близка к молекуле фуллерена – С<sub>60</sub> (Рис. 22 и 24) и, поэтому мною сделано предположение о существовании плоской, раскрытой молекулы графита С<sub>54</sub>, называемой учёными – чешуйкой графита. &nbsp;Молекула графита С<sub>60</sub> – это закрытая трубка (Рис. 22) (подобие трубки), образованная короткодействующими силами притяжения в неполных магнетонах плоской молекулы С<sub>54</sub>,с захватом из окружающего пространства 6 (шести) атомов углерода для строительства завершённой системы нейтрализации спиновых неэлектростатических зарядов на концах трубки. &nbsp;Производство особого вида сажи – фуллеренов из графита, сопровождается свёртыванием плоских молекл графита С<sub>54</sub> в трубки (Рис. 22) и захватом дополнительных 6 (шести) атомов углерода. По внешнему виду трубка фуллерена близка к форме шестигранной правильной прямой призмы (Рис. 22 и 23). &nbsp;На рисунке 21 показаны три возможные направления свёртывания плоских молекул графита С<sub>54</sub> в геометрическое подобие трубки (Рис. 22). В плоскости сечения молекулы С<sub>60</sub> – трубки фуллерена, ядра атомов углерода расположены в вершинах шестиугольников (Рис. 23), короткие и дальние силовые связи (Рис. 20) между ядрами атомов углерода в магнетонах, определяют длину сторон правильного шестиугольника.</div></body></html>";

    @Test
    public void ifLinksGoConsequentiallyTest() throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream("Java.SE.03.Information handling_task_attachment.html"),"windows-1251");
        PictureLinkSearcher pictureLinkSearcher = new PictureLinkSearcher(reader);
        assertEquals(false,pictureLinkSearcher.ifLinksGoConsequentially());
    }

    @Test
    public void getSentencesWithPictureLinksTest() throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream("Java.SE.03.Information handling_task_attachment.html"),"windows-1251");
        PictureLinkSearcher pictureLinkSearcher = new PictureLinkSearcher(reader);
        assertEquals(false,pictureLinkSearcher.ifLinksGoConsequentially());
        List<String> sentenceList = pictureLinkSearcher.getSentencesWithPictureLinks();
        Pattern pattern = Pattern.compile("(Рис. |На рисунке )[\\d]+");
        for (String sentence : sentenceList){
            Matcher matcher = pattern.matcher(sentence);
            assertTrue(matcher.find());
        }
    }
}
