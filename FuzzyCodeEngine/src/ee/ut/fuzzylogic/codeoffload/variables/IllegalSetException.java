/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.fuzzylogic.codeoffload.variables;

/**
 *
 * @author Root
 */
public class IllegalSetException extends Exception {

    /**
     * Creates a new instance of <code>IllegalSetException</code> without detail message.
     */
    public IllegalSetException() {
    }

    /**
     * Constructs an instance of <code>IllegalSetException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IllegalSetException(String msg) {
        super(msg);
    }
}
