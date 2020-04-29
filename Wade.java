import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Wade {

    /**
     * Start Server.
     */
    public static void DoServer() {
        System.out.println("Starting Server!");
        Server s = Server.instance();
        fillDataPollers(s);
        s.runServer();
    }

    public static void fillWidgetsToFactory() {
        WidgetFactory.addWidget("BusWidget", "Bus");
        WidgetFactory.addWidget("WeatherWidget", "Weather");
    }

    public static void fillDataPollers(Server s) {
        DataPollerFactory.addDataPoller("WebDataPoller", "WebDataPoller");
        s.addDataPoller("WebDataPoller");

    }

    /**
     * Start Client.
     */
    public static void DoClient() {
        System.out.println("Starting Client!");
        Client c = new Client();
        fillWidgetsToFactory();
        displayClientMenu(c);
        c.run();
    }

    public static void displayClientMenu(Client c) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Set<String> names = WidgetFactory.getNames();
        System.out.println("Please choose your widgets.\n" +
                "When finished, insert an empty line.");
        for (String name : names) {
            System.out.println("– " + name);
        }
        String input = scanner.nextLine();
        while (!input.isEmpty()) {
            try {
                c.addWidget(input);
            } catch (RuntimeException e) {
                System.out.println("There is no widget with this name.");
            }
            input = scanner.nextLine();
        }
    }

    /**
     * Main function.
     *
     * @param args arguments for main.
     */
    public static void main(String[] args) {
        if (args[0].contentEquals("--server")) {
            DoServer();
        } else if (args[0].contentEquals("--client")) {
            DoClient();
        }
    }

}