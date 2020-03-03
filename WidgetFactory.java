import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WidgetFactory {
    private static final Map<String, String> map = new HashMap<>();

    public static Widget createWidget(String name) {
        try {
            String type = map.get(name);
            return (Widget) Class.forName(type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error: the requested widget does not exist.", e);
        }

    }

    public static void addWidget(String type, String key) {
        map.put(key, type);
    }
}