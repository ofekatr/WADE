package Widgets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WidgetFactory {
    private static final Map<String, String> map = new HashMap<>();

    /**
     * Create a new Widgets.Widget.
     * @param name Widgets.Widget's name.
     * @return the new Widgets.Widget.
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
     * Add name and type of Widgets.Widget to map.
     * @param type Widgets.Widget's type.
     * @param key Widgets.Widget's name.
     */
    public static void addWidget(String type, String key) {
        map.put(key, type);
    }

    public static Set<String> getNames(){
        return map.keySet();
    }
}