import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class DataPollerFactory {
    private static final Map<String, String> map;

    static {
        Map<String, String> hMap = new HashMap<>();
        map = Collections.unmodifiableMap(hMap);
    }

    public static DataPoller createDataPoller(String name) {
        try {
            String type = map.get(name);
            return (DataPoller) Class.forName(type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error: DataPoller does not exist.", e);
        }
    }

    public static void addDataPoller(String type, String key) {
        map.put(key, type);
    }
}
