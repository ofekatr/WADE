import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Server side class - Provides services for client requests.
 */
public class Server {
    private static final int DEFAULT_PORT = 8080;
    private final int port;
    private ServerSocket serverSocket = null;
    private static Server server = null;
    private Map<String, DataPoller> dp;
    private boolean stop;


    // Singleton implementation
    private Server(int port) {
        this.port = port;
        this.dp = new HashMap<>();
    }

    private Server() {
        this.port = DEFAULT_PORT;
        this.dp = new HashMap<>();

    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            throw new RuntimeException("Failed to open port", e);
        }
    }

    public static Server instance() {
        if (server == null)
            server = new Server();
        return server;
    }

    public boolean addDataPoller(String name) {
        this.dp.put(name, DataPollerFactory.createDataPoller(name));
        return true;
    }

    private boolean shouldStop() {
        return this.stop;
    }

    public void runServer() {
        while (!this.shouldStop()) {
            try {
                Socket clientSocket = this.serverSocket.accept();
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                new Thread(
                        new ClientHandler(
                                reader, out, clientSocket, dp)
                ).start();

            } catch (IOException e) {
                if (shouldStop()) {
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }


        }

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