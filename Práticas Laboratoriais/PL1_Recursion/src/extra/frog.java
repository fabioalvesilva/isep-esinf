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
public class frog {
    
    public int nWays (int n){
        
        if (n==0) return 0;
        
        return nWays(n+1);
    }
    
}
