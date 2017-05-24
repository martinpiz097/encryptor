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
public class InvalidTextException extends Exception {

    /**
     * Creates a new instance of <code>InvalidTextException</code> without
     * detail message.
     */
    public InvalidTextException() {
    }

    /**
     * Constructs an instance of <code>InvalidTextException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidTextException(String msg) {
        super(msg);
    }
}
