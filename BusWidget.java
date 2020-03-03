import org.json.JSONArray;
import org.json.JSONObject;

public class BusWidget extends Widget {
    private long LastUpdate = 0;

    String getUrl() {
        return "https://bus.gov.il/WebApi/api/passengerinfo/GetRealtimeBusLineListByBustop/26290/he/false";
    }

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

    @Override
    public String getType() {
        return "WebDataPoller";
    }

    @Override
    protected void handleReply(String reply) {
        this.showBusData(reply);
    }

    @Override
    protected void sendRequest(String url) {
        super.sendRequest(url);
    }

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
