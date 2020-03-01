
public class Client extends Observer {

    private WidgetCollection<Widget> widgets;

    public Client() {
        this.widgets = new WidgetCollection<Widget>();
    }

    public void addWidget(Widget widget) {
        if (widget != null) {
            this.widgets.add(widget);
        }
    }

    /**
     * Update after changes in the observable
     * @param observable the observable that changed
     */
    public void update(Observable observable) {

    }


}
