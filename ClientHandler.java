import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

/**
 * The Client Handler - Handles a single client request in a new thread.
 */
public class ClientHandler extends Thread {
    private final BufferedReader br;
    private final PrintWriter pw;
    private final Socket s;
    private final Map<String, DataPoller> dp;

    /**
     * A class constructor.
     */
    public ClientHandler(BufferedReader br, PrintWriter pw, Socket s, Map<String, DataPoller> dp) {
        this.br = br;
        this.pw = pw;
        this.s = s;
        this.dp = dp;
    }

    /**
     * Thread class method - handle the client's request.
     */
    public void run() {
        try {
            String messageStr = this.br.readLine();
            String type = Message.typeFromMessageStr(messageStr);
            String request = Message.requestFromMessageStr(messageStr);
            DataPoller poller = dp.get(type);
            if (poller == null)
                return;
            String reply = poller.sendRequest(request);
            this.pw.println(reply);
            this.pw.close();
            this.br.close();
            this.s.close();

        } catch (IOException e) {
            throw new RuntimeException("Failed to open port.", e);
        }
    }
}