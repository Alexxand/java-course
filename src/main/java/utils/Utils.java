package utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alexmich on 29.10.16.
 */
public class Utils {
    private Utils(){

    }

    public static String getFileSeparator(){
        return System.getProperty("file.separator");
    }

    public static String getAbsoluteResourcePath(){
        return getAbsoluteResourcePath("");
    }

    public static String getAbsoluteResourcePath(String fileName){
        StringBuilder fullPath = new StringBuilder();
        String workingDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        List<String> dirList = Arrays.asList("src","main","resources");
        fullPath.append(workingDir);
        dirList.forEach(dir -> fullPath.append(separator).append(dir));
        fullPath.append(separator).append(fileName);
        return fullPath.toString();
    }

    public static String getAbsoluteTestResourcePath(){
        return getAbsoluteTestResourcePath("");
    }

    public static String getAbsoluteTestResourcePath(String fileName){
        StringBuilder fullPath = new StringBuilder();
        String workingDir = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        List<String> dirList = Arrays.asList("src","test","resources");
        fullPath.append(workingDir);
        dirList.forEach(dir -> fullPath.append(separator).append(dir));
        fullPath.append(separator).append(fileName);
        return fullPath.toString();
    }
}
