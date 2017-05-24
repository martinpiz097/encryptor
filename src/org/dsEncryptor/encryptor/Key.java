/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsEncryptor.encryptor;

import java.nio.charset.StandardCharsets;
import org.dsEncryptor.exceptions.SmallKeyException;

/**
 *
 * @author martin
 */
public class Key {
    private final byte[] byteKey;

    public Key(String strKey) {
        if (strKey.length() < 2) {
            throw new SmallKeyException("La llave del encriptador es muy pequeña.\n"
                    + "Debe ser mínimo de 2 caracteres");
        }
        this.byteKey = strKey.getBytes(StandardCharsets.UTF_8);
    }

    public char getChar(int pos){
        return (char) byteKey[pos];
    }
    
    public int getKeyLenght(){
        return byteKey.length;
    }
    
    public String getChars(int origin, int end){
        StringBuilder sBuilder = new StringBuilder();
        for (int i = origin; i < end; i++)
            sBuilder.append((char)byteKey[i]);
        return sBuilder.toString();
    }
    
    public byte[] getByteKey() {
        return byteKey;
    }

    @Override
    public String toString() {
        return new String(byteKey);
    }
    
}
