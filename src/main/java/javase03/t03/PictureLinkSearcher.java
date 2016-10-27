package javase03.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by alexmich on 25.10.16.
 */
public class PictureLinkParser  {

    private ArrayList<String> sentenceList = new ArrayList<>();

    private List<String> getMatchesList(Pattern pattern, CharSequence input){
        List<String> matchesList = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            matchesList.add(matcher.group());
        }
        return matchesList;
    }

    public PictureLinkParser(Reader reader) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder tempString = new StringBuilder();
        Pattern pattern = Pattern.compile("[А-Я][^!?]*?[^А-Я][!?\\\\.][\\s]*(?=[А-Я]|$)");
        String line = bufferedReader.readLine();
        while (line != null){
            //todo: исправить с использованием нормальных инструментов, для распарсивания html
            line = line.replaceAll("&nbsp;"," ").replaceAll("</?(b|i|sup|sub|pre)>","");
            tempString.append(line);
            ArrayList<String> paragraphList = new ArrayList<>(Arrays.asList(tempString.toString().split("<[^<>]*>")));
            //todo: попробовать переписать с queue
            if (paragraphList.size() != 0)
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
        Pattern pattern = Pattern.compile("(Рис. |На рисунке )(\\d+)");
        for(String sentence : sentenceList){
            Matcher matcher = pattern.matcher(sentence);
            if(matcher.find()) {
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
        
    }
}
