/**
 * The Observable interface - for observer pattern implementation.
 * Currently unused.
 */
public interface Observable {
    public void addObserver(Observer o);

    public void notifyObservers();

    public void setChanged(boolean changed);

    public boolean hasChanged();

    public void clearChanged();
}
