package javase03.t03;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by alexmich on 25.10.16.
 */
public class PictureLinkSearcher {

    private static final String PICTURE_LINK_PATTERN ="([Рр]ис. |[Нн]а рисунке )(\\d+)";

    private ArrayList<String> sentenceList = new ArrayList<>();

    private List<String> getMatchesList(Pattern pattern, CharSequence input){
        List<String> matchesList = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            matchesList.add(matcher.group());
        }
        return matchesList;

    }

    public PictureLinkSearcher(Reader reader) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder tempString = new StringBuilder();
        Pattern pattern = Pattern.compile("[А-Я][^!?]*?[^А-Я][!?\\\\.][\\s]*(?=[А-Я]|$)");
        String line = bufferedReader.readLine();
        while (line != null){
            //todo: исправить с использованием нормальных инструментов для распарсивания html
            line = line.replaceAll("&nbsp;"," ").replaceAll("</?(b|i|sup|sub|pre)>","");
            tempString.append(line);
            ArrayList<String> paragraphList = new ArrayList<>(Arrays.asList(tempString.toString().split("<[^<>]*>")));
            if (!paragraphList.isEmpty())
                tempString = new StringBuilder(paragraphList.remove(paragraphList.size() - 1));
            else
                tempString = new StringBuilder();
            for (String paragraph : paragraphList){
                sentenceList.addAll(getMatchesList(pattern,paragraph));
            }
            line = bufferedReader.readLine();
        }
        sentenceList.addAll(getMatchesList(pattern,tempString));

        //sentenceList.forEach(System.out::println);
    }

    public boolean ifLinksGoConsequentially(){
        int lastPictureNum = 0;
        Pattern pattern = Pattern.compile(PICTURE_LINK_PATTERN);
        for(String sentence : sentenceList){
            Matcher matcher = pattern.matcher(sentence);
            while(matcher.find()) {
                int curPictureNum = Integer.parseInt(matcher.group(2));
                if (lastPictureNum > curPictureNum)
                    return false;
                else
                    lastPictureNum = curPictureNum;
            }
        }
        return true;
    }

    public List<String> getSentencesWithPictureLinks(){
        List<String> sentencesWithPictureLinks = new ArrayList<>();
        Pattern pattern = Pattern.compile(PICTURE_LINK_PATTERN);
        for (String sentence : sentenceList){
            Matcher matcher = pattern.matcher(sentence);
            if(matcher.find()) {
                sentencesWithPictureLinks.add(sentence);
            }
        }
        return sentencesWithPictureLinks;
    }
}
