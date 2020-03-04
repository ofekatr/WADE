import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class DataPollerFactory {
    private static final Map<String, String> map = new HashMap<>();

    /**
     * Create a DataPoller.
     * @param name DataPoller's name
     * @return new DataPoller.
     */
    public static DataPoller createDataPoller(String name) {
        try {
            String type = map.get(name);
            return (DataPoller) Class.forName(type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error: DataPoller does not exist.", e);
        }
    }

    /**
     * Add DataPoller's information to DataPoller map.
     * @param type the DataPoller's type.
     * @param key DataPoller's name.
     */
    public static void addDataPoller(String type, String key) {
        map.put(key, type);
    }
}
