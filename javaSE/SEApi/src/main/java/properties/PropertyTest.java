package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class PropertyTest {

    public static void main(String[] args) {
//        writeToProperties();
        readProperties();
//        readPropertiesFromResourceBundle();
    }

    private static void readPropertiesFromResourceBundle() {
        Locale locale = new Locale("zh_cn");

        ResourceBundle rb = ResourceBundle.getBundle("properties.area", locale);

        System.out.println(rb.getString("BJ"));
        System.out.println(rb.getString("NJ"));
    }

    private static void writeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("BJ", "Beijing");
        properties.setProperty("NJ", "Nanjing");
        properties.setProperty("XA", "Xian");
        try {
            System.out.println(PropertyTest.class.getResource("./area.properties").getPath());
            String path = PropertyTest.class.getResource("./area.properties").getPath();
            properties.store(new FileOutputStream(path), "Area Info");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readProperties() {
        Properties properties = new Properties();

        try {
            String path = PropertyTest.class.getResource("").getPath() + "area_zh_cn.properties";
            properties.load(new FileInputStream(path));
            System.out.println(properties.getProperty("BJ"));
            System.out.println(properties.getProperty("NJ"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
