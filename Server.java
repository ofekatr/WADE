import java.util.ArrayList;

public class Server implements Observable {

    private boolean changed;
    private ArrayList<Observer> observers;

    public Server() {
        observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        if (this.changed) {
            clearChanged();
        }
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean hasChanged() {
        return this.changed;
    }

    private void clearChanged() {
        this.changed = false;
    }

}