public class SumOfArrayExceptCurrentElement{
    public static void main(String args[]){
        int arr[] = {1,2,3,4};
        int sum = 0;
        for(int i=0; i<arr.length;i++){
            sum=0;
            for(int j=0;j<arr.length;j++){
            if(i!=j && j!=i)
            sum+=arr[j];
            }
            System.out.print(sum);
        }
    }
}