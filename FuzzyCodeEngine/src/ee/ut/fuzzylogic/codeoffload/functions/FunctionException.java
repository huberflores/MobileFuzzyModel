/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.fuzzylogic.codeoffload.functions;

/**
 *
 * @author Root
 */
public class FunctionException extends Exception {

    /**
     * Creates a new instance of <code>FunctionException</code> without detail message.
     */
    public FunctionException() {
    }

    /**
     * Constructs an instance of <code>FunctionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FunctionException(String msg) {
        super(msg);
    }
    
}
