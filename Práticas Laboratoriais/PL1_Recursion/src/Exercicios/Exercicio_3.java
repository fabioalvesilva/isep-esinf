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
public class Exercicio_3 {
    
     public static void main(String[] args) {
         
        int[][] matrix = {
                {1,1,1,0,1,1,0,0,0,1,1,1,1},
                {1,0,1,1,1,0,1,1,1,1,1,0,1},
                {1,0,0,0,1,0,1,0,1,0,1,0,1},
                {1,0,0,0,1,1,1,0,1,0,1,1,1},            
                {1,1,1,1,1,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,1,1,1,1,1} 
        };
        int[][] discoveredMap = check(matrix, 0, 0);
        printMatrix(discoveredMap);
    }
    
    
    public  static int [][] check (int [][] matrix, int y, int x){
        
        //Passo base
        
        matrix[y][x] = 9;
        
        //Fim do Labirinto
        if (y== matrix.length-1 && x==matrix.length-1){
             return matrix;
        }
       
        
        //Passo Recursivo
        
        //GO NORTH
        if (isMoveAllowed(matrix, y-1, x)){
            int [][] result = check(matrix, y-1, x);
            if (result !=  null)
            return result;
        //GO EAST
        } if (isMoveAllowed(matrix, y, x+1)){
            int [][] result = check(matrix, y, x+1);
            if (result != null)
            return result;
        //GO SOUTH
        } if (isMoveAllowed(matrix, y+1, x)){
            int [][] result = check(matrix, y+1, x);
            if (result != null)
            return result;
        } if(isMoveAllowed(matrix, y, x-1)){
            int [][] result = check(matrix, y, x-1);
            if (result != null)
            return result;
        }
        
            matrix[y][x]=2;
            return null;
        
        
        
    }
    
    private static boolean isMoveAllowed (int [][] n, int y, int x){
        
        boolean s = false;
        
        if((y < 0 || y > 6 && x < 0 || x > 12)) return false;
        if(n[y][x]== 1) s = true;
        
        return s;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
}
