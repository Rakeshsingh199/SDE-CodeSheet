
/*  Given two sorted arrays, 
we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a 
sorted array, when n is the size of the first array, 
and m is the size of the second array.       */

import java.util.*;
public class MergeSortedArrays{
public static void main(String args[]){
    long arr1[] = {1,2,5,6,9};
    long arr2[] = {9,10,15,17,29,32};
    int n = arr1.length;
    int m = arr2.length;
    merge(arr1,arr2,n,m);
    System.out.println("first array: " +Arrays.toString(arr1));
    System.out.println("Second array : " + Arrays.toString(arr2));
    
}    
    



 public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        //we find gap using ceil of length of sum of both arrays
        //using gap we compare elements of both array;
        //if is it is lesser then second array we swap the elementts
        //and reduce gap by half;
        int i,j,gap = n+m;
        for( gap=nextgap(gap);gap>0;gap=nextgap(gap)){
              // comparing elements in the first
            // array.
            for(i=0;i+gap<n;i++){
                if(arr1[i]>arr1[i+gap]){
                    long temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }
            // comparing elements in both arrays.

            for(j=gap>n?gap-n:0;i<n && j<m; i++,j++){
                if(arr1[i]>arr2[j]){
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if(j<m){
                // comparing elements in the
                // second array.
                for( j=0;j+gap<m;j++){
                    if(arr2[j]>arr2[j+gap]){
                        long temp = arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
            
        }
        
    }
    public static int nextgap(int gap){
        if(gap<=1){
            return 0;
        }
            return (gap/2)+(gap%2);
            
        }
}
