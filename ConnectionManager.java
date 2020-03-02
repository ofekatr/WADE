import java.util.concurrent.*;

public class ConnectionManager {
    private final int DEF_PORT = 8080;
    private final String DEF_HOST = "localhost";

    private int port;
    private String host;
    private static ConnectionManager cm = null;
    private ExecutorService executor;

    private ConnectionManager(int port, String host) {
        this.executor = Executors.newSingleThreadExecutor();
        this.port = port;
        this.host = host;
    }

    private ConnectionManager() {
        this.executor = Executors.newSingleThreadExecutor();
        this.port = DEF_PORT;
        this.host = DEF_HOST;
    }

    public static ConnectionManager instance() {
        if (cm == null)
            cm = new ConnectionManager();
        return cm;
    }

    public void sendRequest(Message m, Widget w) {
        this.executor.execute(new MessageSendTask(this.host, this.port, m, w));
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPortAndHost(int port, String host) {
        setPort(port);
        setHost(host);
    }
}
