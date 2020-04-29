package Client;

import Widgets.Widget;
import Widgets.WidgetCollection;
import Widgets.WidgetFactory;

import java.util.Iterator;

/**
 * Client.Client side class - The Widgets.Widget manager.
 * Handles all Widgets.Widget operations.
 */

public class Client {

    private WidgetCollection widgets;
    private RequestsManager requestsManager;
    private boolean running;

    /**
     * Class Constructor.
     */
    public Client() {
        this.running = false;
        this.widgets = new WidgetCollection();
        this.requestsManager = new RequestsManager();
    }

    /**
     * Add a widget to the collection by its name.s
     *
     * @param name the name of the widget to be added.
     */
    public void addWidget(String name) {
        Widget w = WidgetFactory.createWidget(name);
        if (w == null)
            return;
        this.widgets.add(w);
        if (this.running)
            this.runWidget(w);
    }

    /**
     * Run and display a given Widgets.Widget in a new thread.
     *
     * @param widget the given widget to run and display.
     */
    public void runWidget(Widget widget) {
        new Thread(() -> {
            while (true) {
                widget.display();
            }
        }).start();
    }

    /**
     * Run the widgets in the collection and display them.
     */
    public void run() {
        this.running = true;
        Iterator it = this.widgets.iterator();
        while (it.hasNext()) {
            Widget widget = (Widget) it.next();
            widget.setRequestsManager(this.requestsManager);
            this.runWidget(widget);
        }
    }
}
