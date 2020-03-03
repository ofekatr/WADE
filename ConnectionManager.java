import java.util.concurrent.*;

/**
 * Connection Manger Class - Handles communication between a client and a given server.
 */
public class ConnectionManager {
    private final int DEF_PORT = 8080;
    private final String DEF_HOST = "localhost";

    private int port;
    private String host;
    private static ConnectionManager cm = null;
    private ExecutorService executor;

    // Class Constructor - Private for Singleton Pattern implementation.
    private ConnectionManager(int port, String host) {
        this.executor = Executors.newSingleThreadExecutor();
        this.port = port;
        this.host = host;
    }

    // Class Constructor - Private for Singleton Pattern implementation.
    private ConnectionManager() {
        this.executor = Executors.newSingleThreadExecutor();
        this.port = DEF_PORT;
        this.host = DEF_HOST;
    }

    /**
     * Singleton Pattern implementation method.
     *
     * @return the Connection Manger.
     */
    public static ConnectionManager instance() {
        if (cm == null)
            cm = new ConnectionManager();
        return cm;
    }

    /**
     * Send a given client request to the Server.
     *
     * @param m Message with the client's request
     * @param w The widget sender of the request.
     */
    public void sendRequest(Message m, Widget w) {
        this.executor.execute(new MessageSendTask(this.host, this.port, m, w));
    }

    /**
     * A set method for port.
     *
     * @param port the value to set.
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * A set method for host.
     *
     * @param host the value to set.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * A set method for both the port and the host.
     *
     * @param port the port value to set.
     * @param host the host value to set.
     */
    public void setPortAndHost(int port, String host) {
        setPort(port);
        setHost(host);
    }
}
