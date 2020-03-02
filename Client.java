
public class Client {

    private WidgetCollection widgets;
    private ConnectionManager connectionManager;
    // TODO: Add a member for display management.


    public Client() {
        this.widgets = new WidgetCollection();
        this.connectionManager = ConnectionManager.instance();
    }

    private void addWidget(String type) {
        Widget w = WidgetFactory.createWidget(type);
        if (w == null)
            return;
        this.widgets.add(w);
    }

    public void run() {
        for (Widget widget : this.widgets) {
            new Thread(() -> {
                while (true) {
                    widget.display();
                }
            }).start();
        }
    }
}
