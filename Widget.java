public abstract class Widget {
    protected String type;
    protected ConnectionManager connectionManager;

    abstract Widget instance();

    abstract void display();

    public String getType() {
        return this.type;
    }

    public boolean sendRequest(String requestStr) {
        return this.connectionManager.sendRequest(new Message(this.type, requestStr));
    }
}
