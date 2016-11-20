package javase05.t02;


import java.io.*;
import java.util.*;

import static utils.Utils.getAbsoluteResourcePath;


public class BundleHandler {

    private PropertyResourceBundle bundle = null;


    public BundleHandler(String propertyFileName) throws IOException, FileNotFoundException {
        try(InputStream stream = new FileInputStream(getAbsoluteResourcePath(propertyFileName))){
            bundle = new PropertyResourceBundle(stream);
        }
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
