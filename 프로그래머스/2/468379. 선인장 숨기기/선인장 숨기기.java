import java.util.*;

class Solution {
    int[][] drops;
   	int m, n, h, w; 
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        this.drops = drops; 
        this.m = m; 
        this.n = n; 
        this.h = h; 
        this.w = w; 
        
        int d = drops.length; 
        
        int left = 0; 
        int right = d;
      	int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; 
           
            // 비가 안 내린 공간이 있는지 
            if (check(mid)) { 
           		answer = mid;
               	left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        
        return getPosition(answer);
    }
    
    public int[] getPosition(int k) {
        int[][] prefix = makePrefix(k); 
        
        for (int r = 0; r <= m - h; r++) {
            for (int c = 0; c <= n - w; c++) {
                int sum = getSum(prefix, r, c);
                
                if (sum == 0) {
                    return new int[] {r, c};
                }
            }
        }
        return new int[] {0, 0};
    }
    
    public boolean check(int mid) {
        int[][] prefix = makePrefix(mid);
        
        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                int sum = getSum(prefix, i, j);
                
                if (sum == 0) 
                    return true; 
            }
        }
           
        return false; 
    }
    
    public int[][] makePrefix(int k) {
        int[][] prefix = new int[m + 1][n + 1]; 
        
        for (int i = 0; i < k; i++) {
            int y = drops[i][0];
            int x = drops[i][1];
            
            prefix[y + 1][x + 1] = 1;
        }
        
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                prefix[r][c] += prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1]; 
            }
        }
        
        return prefix; 
    }
    
    public int getSum(int[][] prefix, int r, int c) {
        int sum = prefix[r + h][c + w] - prefix[r + h][c] - prefix[r][c + w] + prefix[r][c];   
        return sum; 
    }
    
    // 2차원 배열을 순회하는데, 그 내부에서 순회를 하면 O(n^4)이 나오므로 터진다. 
    // 2차원 누적합을 사용해서, 해당 구간의 합이 0이면 비가 내리지 않았다라고 판별할 수 있다. 
    // K번째에서 비가 내렸는지 안내렸는지 체크해서, 안내렸으면 K를 키우면서 뒤에 해당 더 큰게 있는지 체크 
    // 내렸으면 K를 내리면서 구간을 좁힌다. 
    
}