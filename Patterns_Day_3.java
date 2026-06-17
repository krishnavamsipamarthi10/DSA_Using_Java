class Patterns{
    //Question 1
    public static void LeftAlignRightTriangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print("* ");   // in print statement we can use i,j to print numbers
            }
            System.out.println();
        }
    }
    
    //question 2 
    public static void InvertedLeftAlignRightTriangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(n-i+1); //
                if(j < n-i+1)
                    System.out.print(" ");
            }
            if(i<n)
                System.out.println();
        }
    }
    
    // Question 3
    public static void CenterPyramid(int n){
        for(int i=1;i<n;i++){
            // spaces = n-i
            for(int j=1;j<(n-i);j++){
                System.out.print(" ");
            }
            //starts = 2*i-1 (center )
            //starts = k<i (isoceles )
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("* ");
            if(k < (2-i+1))
                System.out.print(" ");
            
            }
            if(i<n)
                System.out.println();
        }
    }
    
    //optimized code for Centre Pyramid
    
    public static void opCenterPyramid(int n){
        for(int i=1;i<n;i++){
            // spaces = n-i
            for(int j=1;j<(n-i);j++){
                System.out.print(" ");
            }
            //starts = 2*i-1 (center )
            //starts = k<i (isoceles )
            for(int k=1;k<=(2*i-1);k++){
                System.out.print("* ");
            if(k < (2-i+1))
                System.out.print(" ");
            
            }
            if(i<n)
                System.out.println();
        }
    }
    
    // Question 4 Diamond
    public static void Diamond(int n){
        int trows = 2*n-1;
        for(int i=1;i<=trows;i++){
            // spaces=Math.abs(n-i);
            int sp=Math.abs(n-i);
            int st=2*(n-sp)-1;
            
            for(int j=1;j<=sp;j++)
                System.out.print(" ");
            //print stars
            for(int k=1;k<=st;k++){
                System.out.print("*");
                if(k<st){
                    System.out.print(" ");
                }
            }
            if(i<trows)
                System.out.println();
        }
    }
    
    //optimized code for diamond
    //applicable for java 11+
    public static void opDiamond(int n){
        // total rows - 2 * n - 1
        int trows = 2*n-1;
        for(int i=1;i<=trows;i++){
            // spaces=Math.abs(n-i);
            int sp=Math.abs(n-i);
            int st=2*(n-sp)-1;
            
            String spStr = " ".repeat(sp);
            String stStr = "* ".repeat(st).trim();
            
            System.out.print(spStr + stStr);
            
            if(i<trows)
                System.out.println();
        }
    }
    
    // Question 5 Floyd Triangle
    public static void FloydTriangle(int n){
        int count = 1;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count);
                if(j<i)
                    System.out.print(" ");
                count++;
            }
            if(i<n)
                System.out.println();
        }
    }
    
    // Question 6
    public static void PascalTriangle(int n){
        for(int i=0;i<n;i++){
            //print spaces
            System.out.print(" ".repeat(n-i-1));
            int val =1;
            for(int j=0;j<=i;j++){
                System.out.print(val);
                if(j < i)
                    System.out.print(" ");
                    
                val = val *(i-j)/(j+1);
            }
            if(i<n-1)
                System.out.println();
        }
    }
    
    // Question 7 Halow Rectangle
    public static void HallowRectangle(int r,int c){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1|| i == r || j == 1|| j == c){
                    System.out.print("x ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
    // Questipn 8
    public static void SpiralMatrix(int n){
        if(n <=0 ) return ;
        int [][] matrix = new int[n][n];
        int value=1;
        int top=0,bottom=n-1,left=0,right=n-1;
        
        while(value <= n*n){
            
            // travese Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // travese Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            //travese left
            for(int i=right; i>=left; i--){
                matrix[bottom][i] = value++;
            }
            bottom--;
            
            //travese up
            for(int i=bottom; i>=top; i--)
                matrix[i][left] = value++;
            left++;
        }
        //print array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", matrix[i][j]);
                
                if(j<n-1)
                    System.out.print(" ");
            }
            if(i<n-1)
                System.out.println();
        }
    }
    
    // Question 9 Zig-zag diagnol paten 
    public static void ZigZag(int n){
        int[][] m = new int[n][n];
        int val=1;
        for(int d=0;d<2*n-1;d++){
            if(d%2==0){
                //Even diagnol - Go Up/right
                int row = (d<n) ? d:n-1;
                int col = d-row;
                while(row>=0 && col<n){
                    m[row][col] = val++;
                    row--;
                    col++;
                }
            }
            else{
                // Odd diagnol: Go Down - Left
                int col = (d<n) ? d : n-1;
                int row = d-col;
                while(row < n && col >= 0){
                    m[row][col] = val++;
                    row++;
                    col--;
                }
            }
        }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.printf("%3d",m[i][j]);
                    if(j < n - 1)
                        System.out.print(" ");
                }
                if(i < n-1)
                    System.out.println();
            }
        }
    //Hallow Diamond
    //Home work question 1
    public static void HallowDiamond(int n){
        // Upper Half
        for (int i = 1; i <= n; i++) {
            // Leading spaces
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            // Hollow stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // Lower Half
        for (int i = n - 1; i >= 1; i--) {
            // Leading spaces
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            // Hollow stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    //Home work question 2 
    public static void numberPyramid(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");      // For spaces

            for(int j = 1; j <= i; j++)
                System.out.print(i + " ");

            System.out.println();
        }
    }

    // HW3
    public static void butterfly(int n) {
        //Left half
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            for(int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
        //Right half
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++)
                System.out.print("*");

            for(int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");

            for(int j = 1; j <= i; j++)
                System.out.print("*");

            System.out.println();
        }
    }
     // HW4
    public static void xPattern(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || i + j == n - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // HW5
    public static void rotatedTriangle(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");

            for(int j = 1; j <= i; j++)
                System.out.print(j + " ");

            System.out.println();
        }
    }
    public static void main(String args[]) {
        //LeftAlignRightTriangle(5);
        //InvertedLeftAlignRightTriangle(5);
        //CenterPyramid(5);
        //Diamond(3);
        //opDiamond(3);
        //FloydTriangle(3);
        //PascalTriangle(5);
        //HallowRectangle(30,30);
        //SpiralMatrix(5);
        //ZigZag(3);
        //HallowDiamond(5);
        //numberPyramid(3);
        //butterfly(3);
        //xPattern(3);
        rotatedTriangle(3);
    }
}
