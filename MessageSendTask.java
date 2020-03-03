import java.io.*;
import java.net.Socket;


/**
 * A Task class - for communication. Executes requests delivery.
 */
public class MessageSendTask implements Runnable {
    private int port;
    private String host;
    private Message message;
    private Widget widget;

    /**
     * A class constructor.
     */
    public MessageSendTask(String host, int port, Message m, Widget w) {
        this.port = port;
        this.host = host;
        this.message = m;
        this.widget = w;
    }

    /**
     * Runnable interface method - Open a connection and send the given request.
     */
    public void run() {
        try {
            Socket clientSocket = new Socket(host, port);
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            out.println(this.message.toString());
            String reply = reader.readLine();
            reader.close();
            out.close();
            clientSocket.close();
            widget.handleReply(reply);

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to open port.", e);
        }
    }
}
