/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsEncryptor.encryptor;

import org.dsEncryptor.exceptions.InvalidTextException;

/**
 *
 * @author martin
 */
public class Encryptor {

    protected final Key key;
    protected StringBuilder sBuilder;
    private static final SysEncryptor SYS_ENCRYPTOR = new SysEncryptor();
    private static final String DEFAULT_KEY_STR = "powerx7";

    protected static final byte MULTIPLIER = 2;
    protected static final byte ADDER = 3;
    
    public Encryptor() {
        this(DEFAULT_KEY_STR);
    }
    
    public Encryptor(String strKey){
        this.key = new Key(strKey);
        this.sBuilder = new StringBuilder();
    }
    
    /*private synchronized String execEncryptation(String text, boolean encrypt) throws InvalidTextException{
       
    }*/
    
    public synchronized String encrypt(String text) throws InvalidTextException{
        sBuilder.delete(0, sBuilder.length());
        if (text == null)
            throw new InvalidTextException();
        
        final char[] chars = text.toCharArray();
        final int charsLen = chars.length;
        char transformed;
        
        sBuilder.append((char)(((int)key.getChar(0))*MULTIPLIER+ADDER));
        for (int i = 0; i < charsLen; i++) {
            transformed = (char)(((int)chars[i])*MULTIPLIER+ADDER);
            sBuilder.append(transformed);
        }
        sBuilder.append('/');
        for (int i = 1; i < key.getKeyLenght(); i++)
            sBuilder.append((char)(((int)key.getChar(i))*MULTIPLIER+ADDER));
        return SYS_ENCRYPTOR.encrypt(sBuilder.toString());
    }
    
    public synchronized String decrypt(String text) throws InvalidTextException{
        text = SYS_ENCRYPTOR.decrypt(text);
        sBuilder.delete(0, sBuilder.length());
        if (text == null)
            throw new InvalidTextException();
        
        final char[] chars = text.toCharArray();
        final int charsLen = chars.length;
        char transformed;
        
        char charAt;
        for (int i = 1; (charAt = chars[i]) != '/'; i++) {
            transformed = (char) (((int)(chars[i])-ADDER)/MULTIPLIER);
            sBuilder.append(transformed);
        }
        return sBuilder.toString();
    }
    
}
