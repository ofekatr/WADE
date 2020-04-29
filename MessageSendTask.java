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
            clientSocket.getOutputStream().write(this.message.toString().getBytes());
            String reply = reader.readLine();
            reader.close();
            clientSocket.close();
            try {
                widget.handleReply(reply);
            } catch (Exception e) {
                System.out.println("An error has occured in reply handling.");
            }

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to open port.", e);
        }
    }
}
