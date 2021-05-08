/*
Given an m x n matrix. If an element is 0, 
set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

if a element in matrix is zero then we have to set its entire row and column to zero

*/
public class SetMatrixZeroes {
    public static void main(String args[]) {
      int arr[][] =  { {1,2,3},{1,4,0},{1,5,4}};    // { {1,1,1},{1,0,1},{1,1,1}}; 
      //{{1,0,4}, {2,4,5}, {0,1,7}};
        int rows = arr.length;
        int columns = arr[0].length;
        setMatrixZeroes(arr,rows,columns);
        printMatrix(arr,rows,columns);
    }
    static void setMatrixZeroes(int arr[][],int n,int m){
        if(arr.length == 0  ||  arr==null || arr[0].length == 0)
            return;
        boolean firstRowZero = false, firstColZero = false;
        for(int i = 0 ; i < n ; i++){
            if(arr[0][i] == 0)
            firstRowZero = true;
        }
        for(int i = 0 ; i < m ; i++)
        {
            if(arr[i][0]==0)
            firstColZero = true;
        }
        for(int i = 1; i < n ; i++){
            for(int j = 1; j < m ; j++){
                if(arr[i][j]==0)
                 {
                 arr[i][0] = 0;
                 arr[0][j] = 0;
                    
                }
            }
        }
            
            for(int i = 1; i < n ; i++){
                for(int j = 1; j < m ; j++){
                    if(arr[i][0] == 0  || arr[0][j] == 0){
                        arr[i][j] = 0;
                    }
                }
            }
            
            if(firstRowZero){
                for(int i = 0 ; i < n ; i++)
                arr[i][0] = 0;
            }
              if(firstColZero){
                  for(int i = 0 ; i < m ; i++) 
                  arr[0][i] = 0;
              }
              
        }
        static void printMatrix(int matrix[][], int rows, int columns){
            for(int i = 0 ; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + " " );
                }
                System.out.println();
            }
        }
}          
                  
                  
                  
            