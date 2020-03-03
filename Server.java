import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Server side class - Satisfies client requests.
 */
public class Server {
    private static final int DEFAULT_PORT = 8080;
    private final int port;
    private ServerSocket serverSocket = null;
    private static Server server = null;
    private Map<String, DataPoller> dp;
    private boolean stop;


    /**
     * A class constructor. Is private for Singleton Implementation.
     */
    private Server(int port) {
        this.port = port;
        this.dp = new HashMap<>();
    }

    /**
     * A class constructor. Is private for Singleton Implementation.
     */
    private Server() {
        this.port = DEFAULT_PORT;
        this.dp = new HashMap<>();

    }

    /**
     * Open a socket for the server's operations.
     */
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            throw new RuntimeException("Failed to open port", e);
        }
    }

    /**
     * Singleton Pattern implementation method.
     *
     * @return the server single instance.
     */
    public static Server instance() {
        if (server == null)
            server = new Server();
        return server;
    }

    /**
     * Add a data poller to be used for the given message type (widget based).
     *
     * @param name the message type relevant to the poller - widget based.
     */
    public void addDataPoller(String name) {
        this.dp.put(name, DataPollerFactory.createDataPoller(name));
    }

    /**
     * A get method for the member stop.
     *
     * @return the value of stop.
     */
    private boolean shouldStop() {
        return this.stop;
    }

    /**
     * Run the server and handle client requests in separate threads.
     */
    public void runServer() {
        this.openServerSocket();
        while (!this.shouldStop()) {
            try {
                Socket clientSocket = this.serverSocket.accept();
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                new Thread(
                        new ClientHandler(
                                reader, clientSocket, dp)
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
}