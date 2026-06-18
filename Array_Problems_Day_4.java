import java.util.*;
import java.util.stream.IntStream;
class ArraysProblems{
    
    //Question 1 Find min amd max
    public static int[] FindMinMax(int a[]){
        if(a == null || a.length == 0){
            throw new IllegalArgumentException("Empty Array");
        }
        int min=a[0], max=a[0];
        for(int i= 0;i<a.length;i++){
            if(a[i]<min)
                min=a[i];
            else
                max=a[i];
        }
        return new int[]{min,max};
        /* //we can use this directly
        IntSummaryStatistics stats = Arrays.stream(a).summaryStatistics();
        return new int[]{stats.getMin(),stats.getMax()};
        */
    }
    
    //Question 2 check 
    public static boolean SortedOrder(int a[]){
        if(a == null || a.length == 0){
            throw new IllegalArgumentException("Empty Array");
        }
        for(int i=0;i<a.length - 1;i++){
            if(a[i]>a[i+1]){
                return false;
            }
        }
        return true;
        //return Arrays.sort(a);
    }
    
    //Question 3 Rotation of array
    public static void RotateArray(int a[],int k){
        int n = a.length;
        // Minimize reundnt full rotation
        k = k % n;
        
        reverse(a,0,n-1);
        reverse(a,0,k-1);
        reverse(a,k,n-1);
    }
    
    //Reverse of the array
    public static void reverse(int a[], int st, int end){
        while(st < end){
            int temp = a[st];
            a[st] = a[end];
            a[end] = temp;
            st++;
            end--;
        }
    }
    
    //Q4 Two sum pair
    public static void TwoSum(int a[],int target){
        if(a==null || a.length<2) return ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:a){
            int complement = target - num;
            if(map.containsKey(complement)){
                int count = map.get(complement);
                for(int i =0;i<count;i++){
                    System.out.println("Pair found: ("+complement+", "+num +")");
                }
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
    }

    // Q5 move zeroes to end
    public static void moveZeroes(int nums[]){
        int inpos = 0;
        for(int idx=0;idx<nums.length;idx++){
            if(nums[idx] != 0) {
                nums[inpos] = nums[idx];
                inpos++;
            }
        }
        while(inpos < nums.length) {
            nums[inpos] = 0;
            inpos++;
        }
    }

    //Q5 another method using streams
    public static void moveZeroes2(int nums[]){
        int[] result = IntStream.concat(
            Arrays.stream(nums).filter(val -> val != 0),
            Arrays.stream(nums).filter(val -> val == 0)
        ).toArray();
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    //Q6
    public static int longestSubArraySum(int[] arr,int k){
        int cursum = 0, maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            cursum += arr[i];
            if(map.containsKey(cursum - k)){
                maxLen = Math.max(maxLen, i-map.get(cursum - k));
            }
            if(!map.containsKey(cursum)){
                map.put(cursum,i);
            }
        }
        return maxLen;
    }
     
    public static int maxProductSubArray(int arr[]){
        int maxpro = arr[0];
        int minpro = arr[0];
        int globalmax = arr[0];

        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            if(curr < 0){
                int temp = maxpro;
                maxpro = minpro;
                minpro = temp;
            }

            maxpro = Math.max(curr, maxpro * curr);
            minpro = Math.min(curr, minpro * curr);

            globalmax = Math.max(globalmax, maxpro);
        }
        return globalmax;
    }
    public static void main(String[] args) {
        //int[] a={10,1,2,5,30};
        //int[] b={1,2,3,4,5,6};
        //int[] c={1,0,2,0,6};
        int[] d={1,2,3,4,1,1,1,1};
        //Q1
        //System.out.println(FindMinMax(a)[0]);
        //System.out.print(FindMinMax(a)[1]);
        
        //Q2
        //System.out.print(SortedOrder(b));
        
        /*//Q3  method 1
        int n= b.length;
        int k=2;
        k=k%n;
        
        // temporary bufffer to hold last k elements
        int[] temp = new int[k];
        System.arraycopy(b, n-k, temp, 0, k);
        System.arraycopy(b,0,b,k,n-k);
        System.arraycopy(temp,0,b,0,k);*/
        
        
        /*//Q3 methos 2 use collectipns
        Integer[] nums = {1,2,3,4,5,6};
        int k1=2;
        Collections.rotate(Arrays.asList(nums),k1);
        System.out.println(Arrays.toString(nums));*/
        
        //Q3 method 3
        //RotateArray(b,2);
        //for(int i:b)
            //System.out.print(i+" ");
            
        // Q4 
        //TwoSum(b,6);

        //Q5 
        //moveZeroes(c);
        //moveZeroes2(c);
        //System.out.println(Arrays.toString(c));

        //Q6
        //System.out.println(longestSubArraySum(d, 7));

        //Q7
        System.out.println(maxProductSubArray(d));
    }
}
