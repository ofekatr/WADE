public abstract class Widget {
    protected String type;
    protected RequestsManager requestsManager;

    public abstract void display();

    public String getType() {
        return this.type;
    }

    protected void sendRequest(String requestStr) {
        this.requestsManager.requestReceived(new Message(this.getType(), requestStr), this);
    }

    protected abstract void handleReply(String reply);
}
