package helpers;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {


        private static Properties props;


        public static void loadProps() {
            File file = new File("./src/main/resources/testconfig.properties");
            try
                    (FileInputStream fileInput = new FileInputStream(file))
            {
                props = new Properties();
                try {
                    props.load(fileInput);
                } catch (IOException e) {
                }
            } catch (IOException e) {
            }
        }

        public static String getProperty (String name, String defaultVal) {
            if (props == null ) loadProps();
            return props.getProperty(name, defaultVal);
        }

        public static int getIntProperty (String name, String defaultVal) {
            if (props == null) loadProps();
            return Integer.parseInt(props.getProperty(name, defaultVal));
        }
    }
