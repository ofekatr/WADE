import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WidgetFactory {
    private static final Map<String, Widget> map;

    static {
        Map<String, Widget> hMap = new HashMap<>();
        map = Collections.unmodifiableMap(hMap);
    }

    public static Widget createWidget(String type) {
        return map.get(type).instance();
    }

    public static boolean addWidget(String type, String key) {
        try {
            map.put(key, (Widget) Class.forName(type).newInstance());
            return true;
        } catch (Exception e) {
            System.out.println("Failed Adding Class To Map.");
            return false;
        }
    }
}