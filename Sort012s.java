/*Sort an array of 0’s 1’s 2’s without using extra space or sorting algo */

//We are given an array of elements consisting of only 0s 1s and 2s
//We need to sort the array without using sorting algorithm or extra space

import java.util.Arrays;
public class Sort012s {
        public static void main(String args[])
        {
        int arr[] = {0,1,2,0,0,2,2,1,1,0};
        int n = arr.length;
        sortDutchAlgorithm(arr,n);//efficient Approach
        System.out.println(Arrays.toString(arr));
        int nums[] = {1,1,2,0,0,0,1,2,0,0,1};
        sortUsingCounting(nums,nums.length);//counting sort approach
        System.out.println(Arrays.toString(nums));
        }
    //method to sort the array using Dutch National Flag Algorithm//
    static void sortDutchAlgorithm(int arr[], int n ){
        int low=0, mid=0,high = n-1;
        //low & mid will be pointing to 0th index and high will be pointing
        //to last index we increment mid pointer by 1 and check with the following
        //conditions. loop through mid<=high
            while(mid<=high){
            switch(arr[mid]){
               
            /*if  we find 0, swap arr[low] & arr[mid]
            and increment both pointer by 1
                            
            */      case 0:{
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                }
                /* if we find 1, just increment mid pointer 
                by 1*/
                case 1:{
                    mid++;
                    break;
                }
                /*if we find 2, swap it with mid & high, decrement high by 1*/
                case 2:{
                    swap(arr,mid,high);
                    high--;
                    break;
                    }
                }    
            }
        }
    //swap function to swap the array varialbes
    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //sort using counting sort algorithm
    public static void sortUsingCounting(int nums[], int n){
        /*in this algorithm we will count the number of 0s 1s and 2s
        and replace them in those positions.*/
        int oneCount=0,zeroCount=0,twoCount=0;
          int k = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == 0)
            zeroCount++;
             if(nums[i]==1)
            oneCount++;
            if(nums[i]==2)
            twoCount++;
        }

        while(zeroCount>0){
            nums[k++] = 0;
            zeroCount--;
        }
       
        
        while(oneCount>0){
            nums[k++] = 1;
            oneCount--;
        }
        while(twoCount>0){
            nums[k++] = 2;
            twoCount--;
        }
    }
        
}