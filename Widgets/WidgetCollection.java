package Widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class WidgetCollection implements Collection<Widget> {

    static final int MAX_CAPACITY = 4;
    private List<Widget> widgetList;

    public WidgetCollection() {
        this.widgetList = new ArrayList<Widget>(MAX_CAPACITY);
    }

    public boolean add(Widget o) {
        if (this.size() < MAX_CAPACITY)
            return this.widgetList.add(o);
        return false;
    }

    public boolean addAll(Collection c) {
        if (this.size() + c.size() <= MAX_CAPACITY)
            return this.widgetList.addAll(c);
        return false;
    }

    public void clear() {
        this.widgetList.clear();
    }

    public boolean contains(Object o) {
        return this.widgetList.contains(o);
    }

    public boolean containsAll(Collection o) {
        return this.widgetList.containsAll(o);
    }

    public boolean equals(Object c) {
        return this.widgetList.equals(c);
    }

    public int hashcode() {
        return 0;
    }

    public boolean isEmpty() {
        return this.widgetList.isEmpty();
    }

    public Iterator<Widget> iterator() {
        return this.widgetList.iterator();
    }

    public boolean remove(Object o) {
        return this.widgetList.remove(o);
    }

    public boolean removeAll(Collection o) {
        return this.widgetList.removeAll(o);
    }

    public boolean retainAll(Collection o) {
        return this.widgetList.retainAll(o);
    }

    public int size() {
        return this.widgetList.size();
    }

    public Object[] toArray() {
        return this.widgetList.toArray();
    }

    public Object[] toArray(Object[] a) {
        return this.widgetList.toArray(a);
    }
}
