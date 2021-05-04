//Find the repeating and the missing number in array
/* 
given an array having value 1.....n we have to find out repeating and missing number
in array
Approach 1: Sort the array and compare the values with index
Appraoch 2 : using count array
Create a temp array temp[] of size n with all initial values as 0.
Traverse the input array arr[], and do following for each arr[i] 
if(temp[arr[i]] == 0) temp[arr[i]] = 1;
if(temp[arr[i]] == 1) output “arr[i]” //repeating
Traverse temp[] and output the array element having value as 0 (This is the missing element)
Time Complexity: O(n)

Auxiliary Space: O(n)

Method 3 (Use elements as Index and mark the visited places)
Approach: 
Traverse the array. While traversing, use the absolute value of every element as
an index and make the value at this index as negative to mark it visited. If something 
is already marked negative then this is the repeating element. To find missing, 
traverse the array again and look for a positive value.
*/
import java.util.*;
public class FindMissingRepeating{
    public static void main(String args[]){
        int arr[] ={1,2,5,4,5 };
        int n = arr.length;
       // findUsingSort(arr,n);
        int arr2[] = {1,2,4,3,1};
       // findUsingCount(arr2,arr2.length);
       findUsingIndex(arr,n);
        
    }
    /* using sorting we can find the repeating and missing number*/
    static void findUsingSort(int arr[] , int n ){
        Arrays.sort(arr);
        int missing =0, repeating = 0;
        for(int i=0; i<n; i++){
            if(arr[i]!=i+1){
                missing = i+1;
               break;
            }
        }
        for(int i = 0 ; i <n-1; i++){
            if(arr[i]==arr[i+1]){
                repeating = arr[i];
            }
        }
        System.out.println(missing+ " missing  ");
        System.out.println(repeating+ " repeating");
                
    }
    
    static void findUsingIndex(int arr[], int n){
        int abs_val= 0;
        for(int i = 0; i<n ; i++){
            //eg array is 2,1,3,5,5
            /*abs_val = 2 abs_val=1  abs_val=3   abs_val=5
              arr[2-1]= 1 arr[0]=1   arr[3-1]=3  arr[4]=5
              arr[2-1]=-1 arr[0]=-2  arr[3]=-5  arr[4]=-5    
                
                arr[0] arr[1] arr[2] arr[3] arr[4]
                  -2    -1             -5   
                        
            */
            abs_val = Math.abs(arr[i]);
            if(arr[abs_val-1]>0){
                arr[abs_val-1] = -arr[abs_val-1];
            }
            else{
                System.out.print(abs_val+ " repeating");
            }
        }
        for(int i = 0; i < n ; i++){
            if(arr[i]>0){
                System.out.println(i+1);
            }
        }
        
    }
    
    
    /*using creating a temp array we can find repeating and missing
        
        static void findUsingCount(int arr2[], int n){
            int missing = 0 , repeating = 0;
            int temp[] = new int[arr2.length];
            for(int i = 0 ; i <n-1 ; i++){
                if(temp[arr2[i]]==0){
                    temp[arr2[i+1]]=1;
                }
               if(temp[arr2[i+1]]==1){
                   repeating = arr2[i];
                   
               }
            }
            for(int i = 0 ; i < n-1; i++){
                if(temp[arr2[i+1]]==0){
                    missing = i+1;
                }
            }
            System.out.println(missing+ " missing");
            System.out.print(repeating+ " repeating");
                
            }
            */
}

