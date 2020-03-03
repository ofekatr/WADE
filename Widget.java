public abstract class Widget {
    protected String type;
    protected ConnectionManager connectionManager;

    public abstract void display();

    public String getType() {
        return this.type;
    }

    public void sendRequest(String requestStr) {
        this.connectionManager.sendRequest(new Message(this.type, requestStr), this);
    }

    public abstract void handleReply(String reply);
}
