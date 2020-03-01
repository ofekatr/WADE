
public class Client extends Observer {

    private WidgetCollection<Widget> widgets;

    public Client() {
        this.widgets = new WidgetCollection<Widget>();
    }

    /**
     * Add new widget to client's widget collection
     * @param widget the new widget to be added
     */
    public void addWidget(Widget widget) {
        if (widget != null) {
            this.widgets.add(widget);
        }
    }

    /**
     * Update after changes in the observable (the server)
     * @param observable the observable that changed
     */
    public void update(Observable observable) {

    }


}
