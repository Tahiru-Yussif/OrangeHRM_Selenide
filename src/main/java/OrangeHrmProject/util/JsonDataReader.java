package OrangeHrmProject.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode loadJsonData(String filePath) throws IOException, IOException {
        return objectMapper.readTree(new File(filePath));
    }
}
