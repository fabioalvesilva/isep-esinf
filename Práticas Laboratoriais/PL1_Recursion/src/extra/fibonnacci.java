/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

/**
 *
 * @author Fábio Silva
 */
public class fibonnacci {
    
    public static int fib (int n){
        
        //PASSO BASE
        if (n < 3) return 1;
        
        //PASSO RECURSIVO
        return fib (n-1) + fib (n-2);
        
    }
    
}
