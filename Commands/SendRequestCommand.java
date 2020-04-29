package Commands;

import Client.Message;
import Widgets.Widget;

public abstract class SendRequestCommand implements Command {
    protected Message m;
    protected Widget w;
    protected int port;
    protected String host;

    /**
     * Send a request to server.
     */
    public abstract void sendRequest();

    /**
     * Execute Commands.Command.
     */
    public void execute() {
        this.sendRequest();
    }

    /**
     * Set message.
     * @param m the message.
     */
    public void setM(Message m) {
        this.m = m;
    }

    /**
     * Set Widgets.Widget.
     * @param w the Widgets.Widget.
     */
    public void setW(Widget w) {
        this.w = w;
    }

    /**
     * Set port.
     * @param port port number.
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Set host.
     * @param host host ip.
     */
    public void setHost(String host) {
        this.host = host;
    }
}
