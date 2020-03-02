import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherWidget extends Widget {
    @Override
    Widget instance() {
        return null;
    }

    @Override
    void display() {
    }

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
    void showWeather(String url, String city) {
        String data = requestWeatherData(url);
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

    String requestWeatherData(String url) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                System.out.println("No body in response");
                return null;
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
