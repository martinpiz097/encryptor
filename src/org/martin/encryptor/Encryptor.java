/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.encryptor;

import java.util.Arrays;

/**
 * Encriptador que utiliza un algoritmo complejo para transformar textos
 * a secuencias numéricas seguras. Usado principalmente para el manejo de contraseñas.
 * @author martin
 */
public class Encryptor {
    /**
     * Llave usada para el algoritmo de encriptación y desencriptación.
     */
    private final String key;

    /**
     * Código numérico de la llave utilizada (secuencia numérica).
     */
    private final int intKey;
    
    /**
     * Llave por defecto asignada en caso de que no se especifique ninguna en
     * el contructor.
     */
    private static final String DEFAULT_KEY = "sysPasswords";

    
    /**
     * Instancia el encriptador utilizando la llave por defecto.
     */
    public Encryptor() {
        this(DEFAULT_KEY);
    }
    
    /**
     * Instancia el encriptador con una llave definida manualmente.
     * @param key Llave utilizada para las encriptaciones, si ésta es
     * de valor null se utilizará la llave por defecto del sistema
     */
    public Encryptor(String key) {
        this.key = key == null ? DEFAULT_KEY : key;
        this.intKey = getKeyToInt();
    }
    
    /**
     * Transforma un texto a una secuencia numérica.
     * @param str Texto a transformar
     * @return Texto transformado en secuencia numérica
     */
    public String encrypt(String str){
        int intChar;
        int counter = 0;
        int intKey = getKeyToInt();
        
        String encryptedStr = "";
        
        for (char c : str.toCharArray()) {
            intChar = c;
            counter++;
            encryptedStr+="["+((intChar*counter)*2*(intKey+3))+"] ";
        }
        
        return encrypt2(encryptedStr.substring(0, encryptedStr.length()-1));
    }
    
    /**
     * Transforma el texto convertido a secuencia numérica al texto original
     * @param str Texto convertido a revertir
     * @return Texto original;
     */
    public String decrypt(String str){
        // hooks --> corchetes
        // joinHooks --> metodo para agrupar la cadena por los corchetes formados
        String[] hooks = joinHooks(decrypt2(str));
        String decryptedText = "";
        
        int counter = 0, intHook, intKey = getKeyToInt()+3;
        char charInt;

        for (String hook : hooks) {
            counter++;
            intHook = toInt(hook.substring(1, hook.length()-1));
            intHook /= intKey;
            intHook /= 2;
            intHook /= counter;
            decryptedText+=(char)intHook;
        }
        
        hooks = null;
        return decryptedText;
    }

    private int getKeyToInt(){
        int intKey = 0;
        
        for (char c : key.toCharArray())
            intKey +=(int)c;
        
        return intKey;
    }
    
    private String[] joinHooks(String str){
        return str.split(" ");
    }
    
    private int toInt(String s){
        return Integer.parseInt(s);
    }
    
    private String encrypt2(String str){
        return Arrays.toString(str.getBytes());
    }
    
    private String decrypt2(String str){
        String[] elements = str.substring(1, str.length()-1).split(", ");
        String decrypted = "";
        
        for (String element : elements)
            decrypted+=((char)Integer.parseInt(element));

        elements = null;
        return decrypted;
    }
    
}