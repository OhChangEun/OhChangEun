import java.util.*;

class Solution {
    class Point {
        int y, x; 
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    // 500개 * 500 중 500 * 500 
    // 125_0000_0000
    // 순회할 때, visited[] 한다면?
    
    // 모든 점에 대해서 bfs 돌려서 
    // {1: 8, 2: 7, 3: 2}
    // 다 순회해서 다 더하고, 순회하면서 돌았던 애들 기록 
    
    int[] dy = { -1, 1, 0, 0 };
    int[] dx = { 0, 0, -1, 1 };
    
    int h; 
    int w; 
    int[][] land; 
    boolean[][] visited;
    public int solution(int[][] land) {
      	this.land = land;
        this.h = land.length; 
        this.w = land[0].length;
       
       	int[][] nums = new int[h][w]; 
        int[][] board = new int[h][w];
        
        int idx = 1;
        visited = new boolean[h][w];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                
      			int sum = 0; 
                if (visited[y][x]) continue; 
                if (land[y][x] == 0) continue; 
                
                List<Point> list = new ArrayList<>();
                sum = bfs(y, x, list); 
               
                for (Point p: list) {
                   	board[p.y][p.x] = sum;
                    nums[p.y][p.x] = idx;
                }
                idx++;
            }
        }
        //p(nums);
        int res = 0;
        
        for (int x = 0; x < w; x++) {
            boolean[] bVisited = new boolean[idx]; 
            int total = 0;
       		for (int y = 0; y < h; y++) {
                int i = nums[y][x];
        		if (land[y][x] == 1 && !bVisited[i]) {
                    bVisited[i] = true;
                    total += board[y][x];
                }
                
                res = Math.max(res, total);
            }
        }
        
        return res;
    }
    public void p(int[][] arr) {
        for (int[] row: arr) {
            for (int num: row) {
            	print(num + " ");    
            }
            print("\n");    
        }
    }
    public void print(Object o) {
        System.out.print(o);
    }
    
    public int bfs(int y, int x, List<Point> list) {
     	visited[y][x] = true; 
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(y, x));

        int cnt = 0;
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
           
            cnt++;
            list.add(new Point(curr.y, curr.x));
            for (int dir = 0; dir < 4; dir++) {
                int ny = curr.y + dy[dir];
                int nx = curr.x + dx[dir];
                
                if (isOut(ny, nx)) continue; 
                if (land[ny][nx] == 0) continue; 
                if (visited[ny][nx]) continue; 
                
                visited[ny][nx] = true; 
                queue.offer(new Point(ny, nx));
            }
        }
        
        return cnt; 
    }
    
    public boolean isOut(int y, int x) {
        return y < 0 || y >= h || x < 0 || x >= w;
    }
}