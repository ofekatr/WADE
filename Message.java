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

    public String toString() {
        return "<" + this.type + ">" + this.requestStr;
    }

    public static String typeFromMessageStr(String message) {
        int start_i = message.indexOf('<') + 1;
        int len = message.indexOf('>') - start_i;
        return message.substring(start_i, len);
    }

    public static String requestFromMessageStr(String message) {
        return message.substring(message.indexOf('>') + 1);
    }
}
