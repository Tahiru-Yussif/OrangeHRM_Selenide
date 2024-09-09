package OrangeHrmProject.util;

import java.io.InputStream;
import java.util.Properties;

public class RoutesConfig {

    private static final String CONFIG_FILE = "routes.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = RoutesConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String userManagementPageUrl() {
        return properties.getProperty("userManagementPageUrl");
    }


}
