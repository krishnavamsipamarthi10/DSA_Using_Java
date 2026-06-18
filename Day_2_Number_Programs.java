import java.util.*;
class NumberProblems{

	//Question 1: Spy Number
    public static boolean isSpy(int n) {
        int sum = 0;
        int product = 1;
        int temp = n;

        while(temp > 0) {
            int digit = temp%10;
            sum += digit;
            product *= digit;
            temp = temp/10;
        }
        return sum == product; //return true/false
    }

    public static void printSpyUpToN(int n) {
        for(int i = 1; i <= n; i++) {
            if(isSpy(i))
                System.out.print(i + ", ");
        }
    }

	// Magic Number
	public static boolean isMagic(int n){
		int temp=n;
		while(temp > 9){
			int sum = 0;
			while(temp >0){
				sum += temp%10;
				temp = temp/10;
			}
			temp = sum;
		}
		return temp ==1;
		
		// if(n<=0) false
		// return (n-1) % 9 == 0
	}
	
	public static void printMagicUpToN(int n) {
        for(int i = 1; i <= n; i++) {
            if(isMagic(i))
                System.out.print(i + ", ");
        }
    }

	// Happy Number
	public static boolean isHappy(int n){
		HashSet<Integer> set = new HashSet<>();
		while(n !=1 && !set.contains(n)){
			set.add(n);
			int sum=0,temp=n;
			while(temp>0){
				int dig = temp %10;
				sum +=(dig*dig);
				temp /=10;
			}
			n= sum ;
			System.out.print(n+" ");
		}
		return n == 1;
	}
	
	public static boolean isNeon(int n){
		//int temp=n;
		long sq = (long) n*n;
		int sum =0;
		while(sq >0){
			sum +=sq%10;
			sq = sq/10;
		}
		return sum == n;
	}
	
	public static void printNeonNumbers(int low, int up){
		for(int i = low; i<=up;i++){
			if(isNeon(i)){
				System.out.print(i+" ");
			}
		}
		//return 0;
	}
	
	public static boolean isPerfect(int n){
		int sum=0;
		if(n < 1) return false;
		for(int i=1;i<n;i++){
			if(n%i==0){
				sum += i;
			}
		}
		return sum == n;
	}
	public static void printPerfectNumber(int n){
		for(int i=2;i<n;i++){
			if(isPerfect(i))
			System.out.print(i+" ");
		}
		//return 0;
	}
	
	// perfect square
	public static boolean isSquare(int n){
		if(n< 0) return false;
		if(n<=1) return false;

		/*long low = 1, high = n/2;
		while(low<=high){
			long mid=low +(high - low)/2;
			long midsq = mid*mid;

			if(midsq == n) return true;

			else if(midsq < n){
				low = mid+1;
			}
			else{
				high = mid-1;
			}
		}
		return false;*/

		return ((double)Math.sqrt(n)) % 1 == 0;
		//Math.sqrt 8.0,10.0 -> 0.0
	}
	public static void printPerfectSquareUpToN(int n) {
        for(int i = 1; i <= n; i++) {
            if(isSquare(i))
                System.out.print(i + ", ");
        }
    }
	// Buzz Number
	public static boolean isBuzz(int n){
		if(n%10==7 || n%7==0){
			 return true;
		}
		else return false;
	}

	public static void printBuzzNUmber(int l,int h){
		for(int i=l;i<h;i++){
			if(isBuzz(i)){
				System.out.print(i+" ");
			}
		}
	}
	// Tribonacci series

	public static void Tribonacci(int n){
		long a=0,b=1,c=1,d=0;
		if(n<0) return;
		
		for(long i=0;i<n;i++){
			if(i==0) System.out.print(a+" ");
			else if(i==1) System.out.print(b+" ");
			else if(i==2) System.out.print(c+" ");
			else{
				d=a+b+c;
				System.out.print(d+" ");
				a=b;
				b=c;
				c=d;
			}
		}
	}

	//Padovan
	// p(n) = p(n-2) + p(n-3)
	// 1 1 1

	public static void generatePandovan(int n){
		if(n<=0) return;
		long a=1,b=1,c=1;
		for(int i=0;i<n;i++){
			if(i<3) System.out.print("1 ");
			else{
				long next = a+b;
				System.out.print(next+" ");
				a=b;b=c;c=next;
			}
		}
	}

	//jacobsthal
	public static void generateJacobsthal(int n){
		if(n<0) return ;
		long a=0,b=1;
		System.out.print("jacobsthal:");
		for(int i=0;i<n;i++){
			if(i==0) System.out.print(a+" ");
			else if(i==1) System.out.print(b+" ");
			else{
				long next = b+2*a;
				System.out.print(next+" ");
				a=b;b=next;
			}
		}
	}

	// HW 1 pronic number
	public static boolean isPronic(int n){
		int k=0;
		for(int i=0;i<n;i++){
			if(i*(i+1)==n)
				return true;
		}
		return false;
	}

	public static void printPronicUpToN(int n) {
        for(int i = 1; i <= n; i++) {
            if(isPronic(i))
                System.out.print(i + ", ");
        }
    }

	// HW 2 unique number
	public static void printUnique(int lo,int up){
		for(int i=lo;i<up;i++){
			int a=i/100;
			int b=(i/10)%10;
			int c= i%10;
			
			if(a!=b && b!=c && c!=a){
				System.out.print(i+" ");
			}
		}
	}

	// HW3 nelson number
	public static  boolean isNelson(int n){
		int num=0;
		while(num < n){
			num =num *10+1;
		}
		return num == n;
	}

	public static void printNelsonUptoN(int n){
		for(int i=1;i<n;i++){
			if(isNelson(i)){
				System.out.print(i+" ");
			}
		}
	}

	// HW 4 Peterson number
	public static boolean isPeterson(int n){
    	int temp = n;
    	int sum = 0;
		while(temp > 0){
			int digit = temp % 10;
			int fact = 1;
			for(int i = 1; i <= digit; i++){
				fact *= i;
			}
			sum += fact;
			temp /= 10;
		}
		return sum == n;
	}

	public static void printPetersonUptoN(int n){
		for(int i=1;i<n;i++){
			if(isPeterson(i)){
				System.out.print(i+" ");
			}
		}
	}

	// HW 5
	/*public static void printPerfectSquarePerfectNumber(int l, int r){
		for(int i = l; i <= r; i++){
			if(printPerfectNumber(i) && printPerfectSquareUpToN(i))
            	System.out.print(i + " ");
        }
    }*/

	public static void main(String args[]){
		//System.out.println(isSpy(123));
		//printSpyUpToN(10000);
		//System.out.print(isMagic(50));
		//printMagicUpToN(1000);
		//System.out.print(isHappy(4));
		//System.out.print(isNeon(9));
		//printNeonNumbers(1,1000000);
		//System.out.print(isPerfect(24));
		//printPerfectNumber(1000);
		//System.out.println(isSquare(10));
		//System.out.println(isBuzz(37));
		//printBuzzNUmber(1, 100);
		//Tribonacci(10);
		//generatePandovan(10);
		//generateJacobsthal(10);
		//System.out.println(isPronic(6));
		//printPronicUpToN(50);
		//printUnique(100, 999);
		//System.out.println(isNelson(111));
		//printNelsonUptoN(1000);
		//System.out.println(isPeterson(145));
		printPetersonUptoN(100000);
		//System.out.println(printPerfectSquarePerfectNumber(1, 100));
	}
}
