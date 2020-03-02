import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private static Server server = null;
    private Map<String, DataPoller> dp;


    // Singleton implementation
    private Server() {
        this.dp = new HashMap<>();
    }

    public static Server instance() {
        if (server == null)
            server = new Server();
        return server;
    }


//    public String sendRequest(String widget, String requst) {
//
//    }
//    private boolean changed;
//    private ArrayList<Observer> observers;
//
//    public Server() {
//        this.observers = new ArrayList<Observer>();
//    }
//
//    /**
//     * Add an observer to this observable
//     * @param o the observer to be added
//     */
//    public void addObserver(Observer o) {
//        observers.add(o);
//    }
//
//    /**
//     * Notify all observers observing this observable about changes
//     */
//    public void notifyObservers() {
//        if (this.changed) {
//            for (Observer observer : observers) {
//                observer.update(this);
//            }
//            clearChanged();
//        }
//    }
//
//    /**
//     * Set the changed value
//     * @param changed the new value
//     */
//    public void setChanged(boolean changed) {
//        this.changed = changed;
//    }
//
//    /**
//     * Return the current changed value
//     * @return variable changed
//     */
//    public boolean hasChanged() {
//        return this.changed;
//    }
//
//    /**
//     * Clear the current changed value and set it to false
//     */
//    public void clearChanged() {
//        this.changed = false;
//    }
//
//    /**
//     * Update after changes in the observable (the data poller)
//     * @param observable the observable that changed
//     */
//    public void update(Observable observable) {
//
//    }

}