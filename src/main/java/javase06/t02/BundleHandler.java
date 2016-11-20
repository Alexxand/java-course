package javase06.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static utils.Utils.getAbsoluteResourcePath;


public class BundleHandler {

    private HashMap<String,String> bundleMap = new HashMap<>();

    public BundleHandler(String propertyFileName) throws IOException, FileNotFoundException {
        PropertyResourceBundle bundle = new PropertyResourceBundle(new FileInputStream(getAbsoluteResourcePath(propertyFileName)));
        Enumeration<String> keys = bundle.getKeys();
        while(keys.hasMoreElements()){
            String curKey = keys.nextElement();
            bundleMap.put(curKey,bundle.getString(curKey));
        }
    }


    /**
     * Returns an answer to the question with the specified number.
     *
     * @param key the number of the question
     * @return An answer to the question
     */
    public String getValue(String key) throws MissingResourceException{
        if (!bundleMap.containsKey(key))
            throw new MissingResourceException("Can't find resource for bundleHandler "
                    +this.getClass().getName()
                    +", key "+key,
                    this.getClass().getName(),
                    key);
        return bundleMap.get(key);
    }
}
