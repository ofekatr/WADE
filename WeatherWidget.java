import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherWidget extends Widget {
    private long LastUpdate = 0;
    String city = "Ramat Gan";

    /**
     * Parse and get the description of the weather from the json
     * @param weather json array containing the description of the weather
     * @return the weather parsed
     */
    HashMap<String, String> getWeatherDescription(JSONArray weather) {
        HashMap<String, String> description = new HashMap<>();

        // Parse from JSON
        String main_desc = weather.getJSONObject(0).getString("main");
        String desc = weather.getJSONObject(0).getString("description");

        description.put("main", main_desc);
        description.put("description", desc);
        return description;
    }

    /**
     * Parse and get the info of the weather from the json
     * @param main json object containing the info of the weather
     * @return the weather parsed
     */
    HashMap<String, Integer> getWeatherInfo(JSONObject main) {
        HashMap<String, Integer> info = new HashMap<String, Integer>();

        // Parse from JSON
        int temp = main.getInt("temp");
        int humidity = main.getInt("humidity");
        int temp_min = main.getInt("temp_min");
        int temp_max = main.getInt("temp_max");

        info.put("temp", temp);
        info.put("humidity", humidity);
        info.put("temp_min", temp_min);
        info.put("temp_max", temp_max);

        return info;
    }

    /**
     * Show weather as parsed from data
     */
    void showWeather(String data, String city) {
        JSONObject obj = new JSONObject(data);
        JSONArray weather = obj.getJSONArray("weather");
        JSONObject main = obj.getJSONObject("main");

        HashMap<String, String> description = getWeatherDescription(weather);
        HashMap<String, Integer> info = getWeatherInfo(main);

        System.out.println("The weather today in " + city + ": " + description.get("main") + " - " +
                description.get("description") + "\n");
        System.out.println("Temperature is " + info.get("temp") + "°C, with min temperature of " + info.get("temp_min")
                + "°C and max temperature of " + info.get("temp_max") + "°C.\nHumidity: " + info.get("humidity") + "%\n");
    }

    /**
     * Get the web URL used to poll data for this widget
     * @return the url used.
     */
    String getUrl() {
        return "http://api.openweathermap.org/data/2.5/weather?q="
            + this.city +
            "&appid=ba602af69e087755dc712a9ec9f29e71&units=metric";
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
     * Display widget.
     */
    @Override
    public void display() {
        long displayThresholdInSeconds = 10;
        long currentTime = System.currentTimeMillis() / 1000;
        if ((currentTime - this.LastUpdate) > displayThresholdInSeconds) {
            this.LastUpdate = currentTime;
            System.out.println("Displaying Weather!");
            this.sendRequest(this.getUrl());
        }
    }

    /**
     * Given the data (json) replied from server, show it on screen.
     * @param reply json retrieved from server
     */
    @Override
    public void handleReply(String reply) {
        this.showWeather(reply, this.city);
    }

    /**
     * Get type name of the widget.
     * @return type name.
     */
    @Override
    public String getType() {
        return "WebDataPoller";
    }
}
