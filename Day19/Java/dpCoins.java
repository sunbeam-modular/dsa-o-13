   // Solution1 
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    // Solution2
    private int climbStairs(int n, int dpArray[]){
        if(n <= 2)
            dpArray[n] = n;
        if(dpArray[n] != -1)
            return dpArray[n];
        else
            dpArray[n] = climbStairs(n-1, dpArray) + climbStairs(n-2, dpArray);
        return dpArray[n];
    }
    public int climbStairs(int n) {
        int dpArray[] = new int[n+1];
        for(int i = 0 ; i < dpArray.length ; i++)
            dpArray[i] = -1;
        return climbStairs(n, dpArray); 
    }
    // Solution3
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int dpArray[] = new int[n+1];
        dpArray[1] = 1;
        dpArray[2] = 2;
        for(int i = 3 ; i <= n ; i++)
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        return dpArray[n];  
    }
    // Solution4
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int prev = 1, curr = 2;
        for(int i = 3 ; i <= n ; i++)
        {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
         return curr;       
    }