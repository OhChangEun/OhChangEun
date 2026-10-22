import java.util.*;

class Solution {
    
    int[] parents;
    public int solution(int n, int[][] costs) {
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
       
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int cnt = 0;
        int answer = 0;
        for (int[] cost: costs) {
            int from = cost[0];
            int to = cost[1];
            
            if (find(from) == find(to)) continue; 
            
            union(from ,to);
            cnt++;
            answer += cost[2];
            
            if (cnt == n - 1) {
                break;
            }
        }
        
        return answer;
    }
    
    public void union(int a, int b) {
       int rootA = find(a);
       int rootB = find(b);
        
       if (rootA > rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    
    public int find(int x) {
        if (x == parents[x]) 
            return x; 
        
        return parents[x] = find(parents[x]);
    }
}