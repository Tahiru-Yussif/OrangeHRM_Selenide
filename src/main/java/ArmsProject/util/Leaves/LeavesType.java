package ArmsProject.util.Leaves;

import ArmsProject.util.AppConfig;
import java.io.InputStream;
import java.util.Properties;

public class LeavesType {
    private static final String LEAVE_TYPE_FILE = "Leaves/leave-type-config.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(LEAVE_TYPE_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLeaveTypeName() {
        return properties.getProperty("LeaveTypeName");
    }
}
