package ArmsProject.util;

import com.warrenstrange.googleauth.GoogleAuthenticator;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("baseURL");
    }

    public static String getLeavePageURL() {
        return properties.getProperty("leavePageURL");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static int TOTPExample() {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        String secretKey = properties.getProperty("niaPatelSecretKey");
        return gAuth.getTotpPassword(secretKey);
    }

    // LEAVES TYPE
    public static String getLeaveTypeName() {
        return properties.getProperty("LeaveTypeName");
    }

}
