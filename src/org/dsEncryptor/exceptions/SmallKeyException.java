/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsEncryptor.exceptions;

/**
 *
 * @author martin
 */
public class SmallKeyException extends RuntimeException {

    /**
     * Creates a new instance of <code>SmallKeyException</code> without detail
     * message.
     */
    public SmallKeyException() {
    }

    /**
     * Constructs an instance of <code>SmallKeyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SmallKeyException(String msg) {
        super(msg);
    }
}
