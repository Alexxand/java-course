package javase04.t01;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.Utils.getAbsoluteResourcePath;

/**
 * Created by alexmich on 29.10.16.
 */
public class KeyWordSearcher {
    private static final List<String> keyWords;

    static {
        List<String> _keyWords;
        try(BufferedReader reader = new BufferedReader(new FileReader(getAbsoluteResourcePath("keywords.txt")))){
            _keyWords = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                _keyWords.add(line.trim());
            }
        } catch(IOException e){
            _keyWords = null;
        }
        keyWords = _keyWords;
    }

    private static final String keyWordsRegex;

    static {
        if (keyWords == null) {
            keyWordsRegex = null;
        }
        else {
            StringBuilder regex = new StringBuilder();
            regex.append("(");
            regex.append(keyWords.get(0));
            keyWords.stream().filter(keyWord -> !keyWord.equals(keyWords.get(0))).forEach(keyWord -> regex.append("|").append(keyWord));
            regex.append(")");
            keyWordsRegex = regex.toString();
        }
    }

    private Map<String,Integer> keyWordsNumberMap = new HashMap<>();

    private static void makeRegexForKeyWords(){

    }
    public void search(InputStream byteStream) throws IOException{
        Pattern pattern = Pattern.compile(keyWordsRegex);
        StringBuilder tempString = new StringBuilder();
        byte[] arr = new byte[100];
        int endOfLastMatches = 0;
        while (byteStream.read(arr) != -1) {
            tempString.append(new String(arr));
            Matcher matcher = pattern.matcher(tempString);
            endOfLastMatches = 0;
            while(matcher.find()){
                String keyWord = matcher.group();
                if (!keyWordsNumberMap.containsKey(keyWord)){
                    keyWordsNumberMap.put(keyWord,1);
                } else {
                    keyWordsNumberMap.put(keyWord,(keyWordsNumberMap.get(keyWord) + 1));
                }
                endOfLastMatches = matcher.end();
            }
            tempString.delete(0,endOfLastMatches);
        }
    }

    public void print(OutputStream stream) throws IOException {
        Set<String> keySet = keyWordsNumberMap.keySet();
        for (String keyWord : keySet){
            String line = keyWord + " " + keyWordsNumberMap.get(keyWord).toString() + '\n';
            stream.write(line.getBytes());
        }
    }
}
