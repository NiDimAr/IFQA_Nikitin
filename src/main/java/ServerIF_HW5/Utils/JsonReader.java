package ServerIF_HW5.Utils;

import ServerIF_HW5.models.AuthRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonReader {
    public static AuthRequest readUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonReader.class
                    .getClassLoader()
                    .getResourceAsStream("user.json");

            if (is == null) {
                throw new RuntimeException("user.json not found");
            }

            return mapper.readValue(is, AuthRequest.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
