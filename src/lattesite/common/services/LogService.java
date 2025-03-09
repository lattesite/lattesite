package lattesite.common.services;

/**
 * Service for logging messages to standard output.
 */
public class LogService {

    /**
     * Logs a message to standard output, prefixed with {@code [LatteSite]}.
     *
     * @param message the message to log
     */
    public void log(String message) {
        System.out.println("[LatteSite] " + message);
    }

}
