import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSendRequestCommand extends SendRequestCommand {
    private ExecutorService executor;


    public ExecutorSendRequestCommand() {
        this.executor = Executors.newSingleThreadExecutor();
    }



    public void sendRequest() {
        this.executor.execute(new MessageSendTask(this.host, this.port, super.m, super.w));
    }
}
