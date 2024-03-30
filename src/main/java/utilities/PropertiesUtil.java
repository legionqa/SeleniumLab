package utilities;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertiesUtil {
    static Properties properties = new Properties();

    public void loadProperties() {
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){

        String secret = System.getenv(key);

        if(secret== null || secret.isEmpty()) {

            if (properties.isEmpty()) {
                new PropertiesUtil().loadProperties();
            }
            return properties.getProperty(key);
        }
        else
            return secret;
    }

    public static void main(String[] args) {
        String secret = PropertiesUtil.getProperty("user_test");
        System.out.printf(secret);
    }

}
