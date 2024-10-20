//time complexity of O(log n) and  space complexity of O(1).
public class binarySearchProblem {
    public static int binarySearch(int[] arr, int value){
        int left=0,right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] == value)
                return mid;
            else if(arr[mid] > value)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,3));
    }
}
