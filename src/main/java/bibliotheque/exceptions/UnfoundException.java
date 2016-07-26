
package bibliotheque.exceptions;

/**
 *
 * @author shiro
 */
public class UnfoundException extends Exception {

    /**
     * Creates a new instance of <code>UnfoundException</code> without custom
     * message.
     */
    public UnfoundException() {
        super("Aucune ligne n'a été renvoyée par la requète.");
    }

    /**
     * Constructs an instance of <code>UnfoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnfoundException(String msg) {
        super(msg);
    }
}
