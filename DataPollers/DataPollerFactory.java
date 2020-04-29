package DataPollers;

import java.util.HashMap;
import java.util.Map;

public class DataPollerFactory {
    private static final Map<String, String> map = new HashMap<>();

    /**
     * Create a DataPollers.DataPoller.
     * @param name DataPollers.DataPoller's name
     * @return new DataPollers.DataPoller.
     */
    public static DataPoller createDataPoller(String name) {
        try {
            String type = map.get(name);
            return (DataPoller) Class.forName(type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error: DataPollers.DataPoller does not exist.", e);
        }
    }

    /**
     * Add DataPollers.DataPoller's information to DataPollers.DataPoller map.
     * @param type the DataPollers.DataPoller's type.
     * @param key DataPollers.DataPoller's name.
     */
    public static void addDataPoller(String type, String key) {
        map.put(key, type);
    }
}
