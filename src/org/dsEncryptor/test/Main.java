/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsEncryptor.test;

import org.dsEncryptor.encryptor.Encryptor;
import org.dsEncryptor.exceptions.InvalidTextException;

/**f
 *
 * @author martin
 */
public class Main {
    public static void main(String[] args) throws InvalidTextException {
        String str = "12345";
        Encryptor encryptor = new Encryptor("llaveTierna");
        String enc = encryptor.encrypt(str);
        String desec = encryptor.decrypt(enc);
        
        System.out.println("Text: "+str);
        System.out.println("Encriptado: "+enc);
        System.out.println("Desencriptado: "+desec);
        
    }
    
    // Tiempo en microsegundos
    public static long currentTime(){
        return System.nanoTime()/1000;
    }
    
}
