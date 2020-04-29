import org.json.JSONException;

public abstract class Widget {
    protected String type;
    protected RequestsManager requestsManager;

    public abstract void display();

    /**
     * Get widget's type.
     * @return string of widget's type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Send request of data retrieval via requestManager using Message.
     * @param requestStr the request
     */
    protected void sendRequest(String requestStr) {
        this.requestsManager.requestReceived(new Message(this.getType(), requestStr), this);
    }

    /**
     * Handles the reply from server
     * @param reply data from server
     */
    protected abstract void handleReply(String reply) throws Exception;
}
