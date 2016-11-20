package javase05.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static utils.Utils.getAbsoluteResourcePath;


public class BundleHandler {

    private PropertyResourceBundle bundle = null;


    public BundleHandler(String propertyFileName) throws IOException, FileNotFoundException {
        bundle = new PropertyResourceBundle(new FileInputStream(getAbsoluteResourcePath(propertyFileName)));
    }


    /**
     * Returns an answer to the question with the specified number.
     *
     * @param key the number of the question
     * @return An answer to the question
     */
    public String getValue(String key) throws MissingResourceException{
        return bundle.getString(key);
    }
}
