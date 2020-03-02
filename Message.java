public class Message {
    private String type;
    private String requestStr;

    public Message(String type, String requestStr) {
        this.type = type;
        this.requestStr = requestStr;
    }

    public String getRequestStr() {
        return this.requestStr;
    }

    public String getType() {
        return type;
    }
}
