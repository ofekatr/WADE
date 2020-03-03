/**
 * The Message class - Wraps requests and replies.
 */
public class Message {
    private String type;
    private String requestStr;

    /**
     * A class constructor
     */
    public Message(String type, String requestStr) {
        this.type = type;
        this.requestStr = requestStr;
    }

    /**
     * A get method for the request string.
     *
     * @return the message's request string.
     */
    public String getRequestStr() {
        return this.requestStr;
    }

    /**
     * A get method for the message type.
     *
     * @return the message's type.
     */
    public String getType() {
        return type;
    }

    /**
     * String representation method.
     *
     * @return String format of the message.
     */
    public String toString() {
        return "<" + this.type + ">" + this.requestStr + "\n";
    }

    /**
     * Parse the type from a given string formatted message.
     *
     * @param message the given string.
     * @return the type.
     */
    public static String typeFromMessageStr(String message) {
        int start_i = message.indexOf('<') + 1;
        int len = message.indexOf('>') - start_i + 1;
        return message.substring(start_i, len);
    }

    /**
     * Parse the request from a given string formatted message.
     *
     * @param message the given string.
     * @return the string request.
     */
    public static String requestFromMessageStr(String message) {
        return message.substring(message.indexOf('>') + 1);
    }
}
