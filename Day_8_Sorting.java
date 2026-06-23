import java.util.*;
class SortingPrograms{
    //Q1 Inversion count using merge sort leetcode 315
    public static long inversionCount(int[] arr){
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length-1);
    }

    private static long mergeSortAndCount(int[] arr,int[] temp,int left , int right){
        long count = 0;
        if(left < right){
            int mid = left + (right - left)/2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid+1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }
    private static long mergeAndCount(int[] arr,int[] temp,int left,int mid,int right){
        int i=left, j=mid+1,k=left;
        long count =0;

        while(i<= mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                //a[i] > a[j]
                count += (mid -i +1);
            }
        }

        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= right)
            temp[k++] = arr[j++];
        for(i= left;i<=right;i++)
            arr[i] = temp[i];
        return count;
    }

    //Q2 Dutch flag leetcode 75
    public static void dutchFlag(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums,mid,high);
                high--;
            }
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //Q3 Kth largest in a array using Quick Sort leetcode 215
    public static int KLargestSelect(int[] nums,int k){
        int targetIdx = nums.length-k;
        return quickSelec(nums,0,nums.length-1,targetIdx);
    }

    public static int quickSelec(int[] nums, int left, int right,int targetIdx){
        if(left == right) return nums[left];
        Random rand = new Random();
        int pivot = left +rand.nextInt(right -left +1);

        pivot = partition(nums,left,right,pivot);

        if(pivot == targetIdx)
            return nums[pivot];
        else if (pivot < targetIdx)
        return quickSelec(nums, pivot + 1, right, targetIdx);
        else
        return quickSelec(nums, left, pivot - 1, targetIdx);
    }

    private static int partition(int[] nums,int left,int right,int pivot){
        int pivotValue = nums[pivot];
        swap(nums,pivot,right);
        int storeIdx = left;

        for(int i = left;i<right;i++){
            if(nums[i] < pivotValue){
                swap(nums,i,storeIdx);
                storeIdx++;
            }
        }
        return storeIdx;
    }
    public static void main(String[] args) {
        //Q1
        //System.out.println(inversionCount(new int[] {8,4,2,1}));

        //q2
        /*int[] nums = {2, 0, 2, 1, 1, 0};
        dutchFlag(nums);
        System.out.println(Arrays.toString(nums));*/

        //Q3
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(KLargestSelect(arr, 2));
    }
}
