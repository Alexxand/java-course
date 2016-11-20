package javase07.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

import static utils.Utils.getAbsoluteResourcePath;


public class BundleHandler {

    private PropertyResourceBundle bundle = null;


    public BundleHandler(String propertyFileName) throws IOException, FileNotFoundException {
        String absolutePath = getAbsoluteResourcePath(propertyFileName).intern();
        synchronized (absolutePath) {
            try (InputStream stream = new FileInputStream(absolutePath)) {
                bundle = new PropertyResourceBundle(stream);
            }
        }
    }


    /**
     * Returns an answer to the question with the specified number.
     *
     * @param key the number of the question
     * @return An answer to the question
     */
    public String getValue(String key) throws MissingResourceException {
        return bundle.getString(key);
    }
}
