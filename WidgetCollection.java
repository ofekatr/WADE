import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class WidgetCollection<Widget> implements Collection<Widget> {
    private ArrayList<Widget> widgets;

    public WidgetCollection() {
        this.widgets = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.widgets.size();
    }

    @Override
    public boolean isEmpty() {
        return this.widgets.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.widgets.contains(o);
    }

    @Override
    public Iterator<Widget> iterator() {
        return this.widgets.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.widgets.toArray(a);
    }

    @Override
    public boolean add(Widget widget) {
        return this.widgets.add(widget);
    }

    @Override
    public boolean remove(Object o) {
        return this.widgets.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.widgets.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Widget> c) {
        return this.widgets.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.widgets.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.widgets.retainAll(c);
    }

    @Override
    public void clear() {
        this.widgets.clear();
    }
}
