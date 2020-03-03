import java.util.ArrayList;

/**
 * The DataPoller abstract class - Determines polling methods resources and strategies, e.g.: usage of databases,
 * proxies, external services, etc.
 */
public abstract class DataPoller {

    /**
     * @param request The client request to be analyzed and satisfied.
     * @return Reply for the given request.
     */
    public abstract String sendRequest(String request);
}
