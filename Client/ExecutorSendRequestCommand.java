package Client;

import Commands.SendRequestCommand;
import Tasks.MessageSendTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSendRequestCommand extends SendRequestCommand {
    private ExecutorService executor;

    /**
     * Class constructor.
     */
    public ExecutorSendRequestCommand() {
        this.executor = Executors.newSingleThreadExecutor();
    }

    /**
     * Send a request to server.
     */
    public void sendRequest() {
        this.executor.execute(new MessageSendTask(this.host, this.port, super.m, super.w));
    }
}
