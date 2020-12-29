/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicios;

/**
 *
 * @author Fábio Silva
 */
public class Exercicio_1 {
    
    
    public static String reverseString (String str){
        
        //CASO BASE 
        if (str.length() == 0){
            return "";
        }
 
        //CASO 
        return  reverseString(str.substring(1))+ str.charAt(0);
    }
    
}
