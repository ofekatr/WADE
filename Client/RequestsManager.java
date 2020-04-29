package Client;

import Commands.SendRequestCommand;
import Widgets.Widget;

/**
 * Request Manger Class - Handles communication between a client and a given server.
 */
public class RequestsManager {
    private final int DEF_PORT = 8080;
    private final String DEF_HOST = "localhost";
    private int port;
    private String host;
    private SendRequestCommand command;

    /**
     * Class constructor
     * @param port port number
     * @param host host ip
     * @param sendRequestCommand used to send requests and handle connection
     */
    public RequestsManager(int port, String host, SendRequestCommand sendRequestCommand) {
        this.port = port;
        this.host = host;
        sendRequestCommand.setPort(port);
        sendRequestCommand.setHost(host);
        this.command = sendRequestCommand;
    }

    /**
     * Class constructor
     */
    public RequestsManager() {
        this.port = DEF_PORT;
        this.host = DEF_HOST;
        SendRequestCommand sendRequestCommand = new ExecutorSendRequestCommand();
        sendRequestCommand.setHost(this.host);
        sendRequestCommand.setPort(this.port);
        this.setCommand(sendRequestCommand);
    }

    /**
     * Singleton Pattern implementation method.
     *
     * @return the Requests Manger.
     */
//    public static Client.RequestsManager instance() {
//        if (rm == null) {
//            rm = new Client.RequestsManager();
//            Commands.SendRequestCommand sendRequestCommand = new Widgets.Client.ExecutorSendRequestCommand();
//            sendRequestCommand.setHost(rm.host);
//            sendRequestCommand.setPort(rm.port);
//            rm.setCommand(sendRequestCommand);
//        }
//        return rm;
//    }

    /**
     * Send a given client request to the Server.Server.
     *
     * @param m Client.Message with the client's request
     * @param w The widget sender of the request.
     */
    public void requestReceived(Message m, Widget w) {
        this.command.setM(m);
        this.command.setW(w);
        this.command.sendRequest();
    }

    public void setCommand(SendRequestCommand command) {
        command.setPort(this.port);
        command.setHost(this.host);
        this.command = command;
    }

    /**
     * A set method for port.
     *
     * @param port the value to set.
     */
    public void setPort(int port) {
        this.port = port;
        this.command.setPort(port);
    }

    /**
     * A set method for host.
     *
     * @param host the value to set.
     */
    public void setHost(String host) {
        this.host = host;
        this.command.setHost(host);
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
