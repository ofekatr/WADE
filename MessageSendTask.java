import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;

public class MessageSendTask implements Runnable {
    private int port;
    private String host;
    private Message message;
    private Widget widget;

    public MessageSendTask(String host, int port, Message m, Widget w) {
        this.port = port;
        this.host = host;
        this.message = m;
        this.widget = w;
    }

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
