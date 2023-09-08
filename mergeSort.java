import java.util.Scanner;

public class mergeSort {
    static void getArray(int []arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array element");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
    }
    static void printArray(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void merge(int[] arr,int s,int m,int e){
        int n1=m-s+1;
        int n2=e-m;
        int []left=new int[n1];
        int [] right =new int[n2];
        for(int i=0;i<n1;i++) left[i]=arr[s+i];
        for(int j=0;j<n2;j++) right[j]=arr[m+1+j];
        int i=0,j=0,l=s;
        while(i<n1&&j<n2){
            if (left[i]<right[j]) {
                arr[l++]=left[i++];
            }
            else{
                arr[l++]=right[j++];
            }
        }
        while(i<n1){
            arr[l++]=left[i++];
        }
        while(j<n2){
            arr[l++]=right[j++];
        }
    }
    static void mergeSort(int []arr,int startIndex,int endIndex){
        if(startIndex>=endIndex) return;
        int midIndex=(startIndex+endIndex)/2;
        mergeSort(arr,startIndex,midIndex);
        mergeSort(arr,midIndex+1,endIndex);
        merge(arr,startIndex,midIndex,endIndex);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array:");
        int n=sc.nextInt();
        int []arr=new int[n];
        getArray(arr);
        System.out.println("Your Entered array is:");
        printArray(arr);
        System.out.println("Sorted arr is:");
        mergeSort(arr,0,n-1);
        printArray(arr);
    }
}
