import org.json.JSONArray;
import org.json.JSONObject;

public class BusWidget extends Widget {
    private long LastUpdate = 0;

    /**
     * Get the web URL used to poll data for this widget
     * @return the url used.
     */
    String getUrl() {
        return "https://bus.gov.il/WebApi/api/passengerinfo/GetRealtimeBusLineListByBustop/26290/he/false";
    }

    /**
     * Display widget.
     */
    @Override
    public void display() {
        long displayThresholdInSeconds = 10;
        long currentTime = System.currentTimeMillis() / 1000;
        if ((currentTime - this.LastUpdate) > displayThresholdInSeconds) {
            this.LastUpdate = currentTime;
            System.out.println("Displaying Bus!");
            this.sendRequest(this.getUrl());
        }
    }

    /**
     * Get type name of the widget.
     * @return type name.
     */
    @Override
    public String getType() {
        return "WebDataPoller";
    }

    /**
     * Given the data (json) replied from server, show it on screen.
     * @param reply json retrieved from server
     */
    @Override
    protected void handleReply(String reply) {
        this.showBusData(reply);
    }

    /**
     * Send request of data given the url.
     * @param url url used to retrieve data.
     */
    @Override
    protected void sendRequest(String url) {
        super.sendRequest(url);
    }

    /**
     * Show all bus data as stated on data retrieved from server.
     * @param data json-type data containing all information needed.
     */
    void showBusData(String data) {
        JSONArray busLines = new JSONArray(data);

        for (int i = 0; i < busLines.length(); i++) {
            JSONObject line = busLines.getJSONObject(i);
            int lineNumber = line.getInt("Shilut");
            int minutes = line.getInt("MinutesToArrival");
            if (minutes == 0) {
                System.out.println("Bus line number " + Integer.toString(lineNumber) + " arrived to the station.\n");
            } else {
                System.out.println("Bus line number " + Integer.toString(lineNumber) + " will arrive in the station in "
                        + Integer.toString(minutes) + " minutes.\n");
            }
        }
    }

}
