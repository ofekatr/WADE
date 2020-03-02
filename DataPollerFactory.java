import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataPollerFactory {
    private static final Map<String, DataPoller> map;

    static {
        Map<String, DataPoller> hMap = new HashMap<>();
        map = Collections.unmodifiableMap(hMap);
    }

    public static DataPoller createDataPoller(String type) {
        return map.get(type).instance();
    }

    public static boolean addDataPoller(String type, String key) {
        try {
            map.put(key, (DataPoller) Class.forName(type).newInstance());
            return true;
        } catch (Exception e) {
            System.out.println("Failed Adding Class To Map.");
            return false;
        }
    }
}
