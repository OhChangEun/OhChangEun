import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int n;
    
    public int solution(int n, int[][] wires) {
   		this.n = n;	
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire: wires) {
            int u = wire[0];
            int v = wire[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       
        int minDiff = n - 1;
        for (int[] wire: wires) {
            int start1 = wire[0];
            int start2 = wire[1];
            
            int cnt1 = bfs(start1, start2);
            int cnt2 = bfs(start2, start1);
           
            int diff = Math.abs(cnt2 - cnt1); 
           	minDiff = Math.min(minDiff, diff); 
        }
  
        // print(graph);
        return minDiff;
    }
    
    public int bfs(int start, int wall) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        boolean[] visited = new boolean[n + 1];
        visited[start] = true; 
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
           	cnt++;
            
            for (int next: graph.get(curr)) {
                if (!visited[next] && next != wall) {
                    visited[next] = true;
                   	queue.offer(next); 
                }
            }
        }
       	return cnt; 
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}