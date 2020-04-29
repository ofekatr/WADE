package Widgets;

import Client.Message;
import Client.RequestsManager;

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
     * Send request of data retrieval via requestManager using Client.Message.
     * @param requestStr the request
     */
    protected void sendRequest(String requestStr) {
        this.requestsManager.requestReceived(new Message(this.getType(), requestStr), this);
    }

    /**
     * Handles the reply from server
     * @param reply data from server
     */
    public abstract void handleReply(String reply) throws Exception;

    public RequestsManager getRequestsManager() {
        return requestsManager;
    }

    public void setRequestsManager(RequestsManager requestsManager) {
        this.requestsManager = requestsManager;
    }
}
