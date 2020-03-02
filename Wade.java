public class Wade {
    public static void main(String[] args) {
        WeatherWidget weatherWidget = new WeatherWidget();
        BusWidget busWidget = new BusWidget();
        String urlBus = "https://bus.gov.il/WebApi/api/passengerinfo/GetRealtimeBusLineListByBustop/26290/he/false";
        String urlWeather = "http://api.openweathermap.org/data/2.5/weather?q="
                + "Ramat Gan" +
                "&appid=ba602af69e087755dc712a9ec9f29e71&units=metric";
        weatherWidget.showWeather(urlWeather);
        busWidget.showBusData(urlBus);
    }
}