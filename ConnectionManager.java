import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionManager {
    private final static int queueCapacity = 1024;
    private BlockingQueue<Message> messages;
    private static ConnectionManager cm = null;

    private ConnectionManager() {
        this.messages = new ArrayBlockingQueue<>(queueCapacity);
    }

    public static ConnectionManager instance() {
        if (cm == null)
            cm = new ConnectionManager();
        return cm;
    }

    public boolean sendRequest(Message r) {
        return this.messages.add(r);
    }
}
