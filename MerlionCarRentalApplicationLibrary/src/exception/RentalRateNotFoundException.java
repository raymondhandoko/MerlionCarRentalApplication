/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author raymond
 */
public class RentalRateNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>RentalRateNotFoundException</code>
     * without detail message.
     */
    public RentalRateNotFoundException() {
    }

    /**
     * Constructs an instance of <code>RentalRateNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public RentalRateNotFoundException(String msg) {
        super(msg);
    }
}
