public class Solution {
    int[][] land; 
    int P, Q;
  	int n; 
    
    public long solution(int[][] land, int P, int Q) {
        this.land = land; 
        this.P = P; 
        this.Q = Q; 
        
        this.n = land.length; 
     
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, land[i][j]);
                min = Math.min(min, land[i][j]);
            }
        }
                
        int left = min;
        int right = max; 
        while (left < right) {
            int mid = (left + right) / 2;
           		 
            if (getCost(mid) > getCost(mid + 1)) {
            	left = mid + 1; 
            } else {
               	right = mid; 
            }
        }
                
        return getCost(left);
    }
    
    public long getCost(int value) {
       	long sum = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += value > land[i][j] ? (long)(value - land[i][j]) * P : (long)(land[i][j] - value) * Q;
            }
        }
   
        return sum;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
    
}