public abstract class Widget {
    protected String type;
    protected ConnectionManager connectionManager;

    public abstract void display();

    public String getType() {
        return this.type;
    }

    protected void sendRequest(String requestStr) {
        this.connectionManager.sendRequest(new Message(this.getType(), requestStr), this);
    }

    protected abstract void handleReply(String reply);
}
