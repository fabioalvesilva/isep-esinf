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
public class Exercicio_2 {
    
    
    public static int productTwoInt (int m, int n){
       
          if ( n==0){
              return 0;
          }
          if (n == 1){
              return m;
          }
          
          return m + productTwoInt (m, n-1);
    }
    
}
