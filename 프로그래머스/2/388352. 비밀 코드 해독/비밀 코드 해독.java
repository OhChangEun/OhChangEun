class Solution {
    int n;
    int[][] q; 
    int[] ans; 
    
    int[] selected;
    boolean[] visited;
    
    final int SIZE = 5;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
         
        visited = new boolean[n + 1];
        selected = new int[SIZE];
        dfs(1, 0);
        
        return result;
    }
   
    int result = 0;
    public void simulation(int[] arr) {
        int n = q.length; 
        
        boolean validCode = true;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (q[i][j] == arr[k]) {
                        cnt++;
                        continue;
                    }
                }
            }        
            if (cnt != ans[i]) 
                validCode = false;
        }
    
        if (validCode) 
            result++;
    }
   
    // 1 2 3 4 5 
    // 1 2 3 4 6 
    // 1 2 3 4 7 
    // ...
    public void dfs(int start, int depth) {
        if (depth == SIZE) {
            simulation(selected); 
            return;
        }  
        
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
    public void print(Object o) {
        System.out.print(o);
    }
}