public abstract class SendRequestCommand implements Command {
    protected Message m;
    protected Widget w;
    protected int port;
    protected String host;

    public abstract void sendRequest();

    public void execute() {
        this.sendRequest();
    }

    public void setM(Message m) {
        this.m = m;
    }

    public void setW(Widget w) {
        this.w = w;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
