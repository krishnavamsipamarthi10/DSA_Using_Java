import java.util.*;
class Search_day_7{
	// Q1 Find target value in sorted array
	public static int searchValue(int[] nums, int target){
		int low =0 , high = nums.length-1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(nums[mid] ==target) return mid;
			else if(nums[mid] < target ) low = mid+1;
			else high = mid -1;
		}
		return -1;
		//int result = Arrays.binarySearch(nums,target);
		//return result >=0 ? result : -1;
	}
	
	//Q2 First and last position of target value in sorted array{leetcode 34}
	public static int[] searchRange(int[] nums,int target){
		int first = findBound(nums,target, true);
		if(first == -1) return new int[]{-1,-1};
		int last = findBound(nums,target, false);
		return new int[]{first,last};
	}
	
	private static int findBound(int[] nums, int target, boolean isFirst){
		int low=0,high =nums.length -1,ans= -1;
		while(low <=high){
			int mid = low + (high - low ) / 2;
			if(nums[mid] == target){
				ans = mid;
				if(isFirst) high = mid -1;
				else low = mid+1;
			}
			else if(nums[mid] < target ) low = mid +1;
			else high = mid -1;
		}
		return ans;
	}
	
	//Q3 Find minimum element in rotated array
	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]){
				low = mid + 1; 
			}else{
				high = mid;
			}
		}
		return nums[low];
	}
	
	//Q4 Search in rotated array
	public static int searchRotated(int[] nums, int target){
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) return mid;
			
			// check if left half is sorted
			if(nums[low] <= nums[mid]){
				if(target >= nums[low] && target < nums[mid]){
					high = mid -1;
				}
				else low = mid +1;
			}
			
			// right half 
			else {
				if(target > nums[mid] && target <= nums[high]){
					low = mid + 1;
				}else{
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
	// Q5 find sqrt using binary searchRange
	public static int sqrt(int x){
		if(x==0) return 0;
		int low =0,high =x,ans=1;
		while(low <=high){
			int mid = low + (high - low ) / 2;
			if(mid <=x /mid){
				ans = mid;
				low = mid +1;
			}else high = mid -1;
		}
		return ans;
	}
	
	//Q6 Book Allocation Problem
	public static int findPages(int[] a,int m,int n){
		if(m>n) return -1;
		int low =0,high =0;
		for(int book:a){
			low = Math.max(low,book);
			high += book;
		}
		
		int ans = -1;
		while(low <= high){
			int mid = low + (high - low) /2;
			if(isPossible(a,m,mid)){
				ans = mid;
				high = mid -1;
			}else low = mid +1;
		}
		return ans;
	}
	
	private static boolean isPossible(int[] a,int students, int maxpages){
		int studentsRequired = 1;
		int currentPages = 0;
		
		for(int book : a){
			if(currentPages + book > maxpages){
				studentsRequired++;
				currentPages = book;
				if(studentsRequired > students) return false;
			}
			else currentPages += book;
		}
		return true;
	}
	
	
	//Q7
	public static int aggressiveCows(int[] stalls,int k){
		int n=stalls.length;
		int low =1,high stalls[n-1]
	}
	
	private boolean canplaceCows(int[] stalls,int cows,int dist){
		int count =1;
		int lastPlaced = stalls[0];
		
		for(int i=1,i<stalls.length;i++){
			count++;
			lastPlaced = stalls[i];
			if(count >=cows) return true;
		}
	}
	
	
	//Q8
	public static int painterPartition(int[] boards,int k){
		int n = boards.length;
		if(k > n){
			int maxBoard = 0;
			for(int board: boards){
				maxBoard = Math.max(maxBoard, board);
			}
			return maxBoard;
		}
		int low=0,high =0;
		
	}
	
	private static boolean isPossible(int[] a,int students, int maxpages){
		int studentsRequired = 1;
		int currentPages = 0;
		
		for(int book : a){
			if(currentPages + book > maxpages){
				studentsRequired++;
				currentPages = book;
				if(studentsRequired > students) return false;
			}
			else currentPages += book;
		}
		return true;
	}
	
	
	public static void main(String[] args){
		
		//Q1 
		/*int[] a={1,2,3,4,5};
		System.out.print(searchValue(a,50));*/
		
		
		//Q2 
		/*int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));*/
		
		
		//Q3 
		/*int[] x={30,99,55,0,10,20};
		System.out.print(findMin(x));*/
		
		
		//Q4 
		//System.out.println(searchRotated(new int[]{4,5,6,7,0,1,2}, 0));
		
		
		//Q5
		//System.out.print(sqrt(40));
		
		//Q6
		int[] books = {12, 34, 67, 90};
		int students = 2;
		System.out.println(findPages(books, students, books.length));
	}
}
