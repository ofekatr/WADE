import java.util.Iterator;
import java.util.List;

public class WidgetIterator implements Iterator<Widget> {
    WidgetIterator(List<Widget> widgets) {

    }

    public boolean hasNext() {
        return false;
    }

    // moves the cursor/iterator to next element
    public Widget next() {
        return null;
    }

    // Used to remove an element. Implement only if needed
    public void remove() {
        // Default throws UnsupportedOperationException.
    }
}
