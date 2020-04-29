import java.util.*;

public class WidgetFactory {
    private static final Map<String, String> map = new HashMap<>();

    /**
     * Create a new Widget.
     * @param name Widget's name.
     * @return the new Widget.
     */
    public static Widget createWidget(String name) {
        try {
            String type = map.get(name);
            return (Widget) Class.forName(type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error: the requested widget does not exist.", e);
        }
    }

    /**
     * Add name and type of Widget to map.
     * @param type Widget's type.
     * @param key Widget's name.
     */
    public static void addWidget(String type, String key) {
        map.put(key, type);
    }

    public static Set<String> getNames(){
        return map.keySet();
    }
}