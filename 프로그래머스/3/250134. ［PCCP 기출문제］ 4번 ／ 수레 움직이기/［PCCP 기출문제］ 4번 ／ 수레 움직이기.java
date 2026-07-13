class Solution {
   	int[] dy = { -1, 1, 0, 0 }; 
   	int[] dx = { 0, 0, -1, 1 }; 
    
    boolean[][] walls;
    boolean[][] redVisited;
    boolean[][] blueVisited;
    
    int n, m;
    int redY, redX;
    int blueY, blueX;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
       	n = maze.length;
        m = maze[0].length;
  			
        walls = new boolean[n][m];
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        
        int sy1 = 0, sx1 = 0;
        int sy2 = 0, sx2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = maze[i][j];
                
                switch (num) {
                    case 1:
                        sy1 = i; sx1 = j;
                        break;
                    case 2:
                        sy2 = i; sx2 = j;
                        break;
                    case 3:
                        redY = i; redX = j;
                        break;
                    case 4:
                       	blueY = i; blueX = j;
                        break;
                    case 5:
                        walls[i][j] = true;
                        break;
                }
            }
        }
        int depth = 0;
        dfs(sy1, sx1, sy2, sx2, depth);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(int y1, int x1, int y2, int x2, int depth) {
        // 방문 처리 
        redVisited[y1][x1] = true; 
        blueVisited[y2][x2] = true; 
        
        boolean redReach = (y1 == redY && x1 == redX);
        boolean blueReach = (y2 == blueY && x2 == blueX);

        if (redReach && blueReach) {
   			answer = Math.min(answer, depth);
            
            redVisited[y1][x1] = false; 
        	blueVisited[y2][x2] = false; 
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int ny1 = redReach ? y1 : y1 + dy[i]; // 방문할 경우 위치 고정
            int nx1 = redReach ? x1 : x1 + dx[i];
            
            if (isOut(ny1, nx1)) continue; 
            if (walls[ny1][nx1]) continue;
            if (!redReach && redVisited[ny1][nx1]) continue;
            
        	for (int j = 0; j < 4; j++) {
            	int ny2 = blueReach ? y2 : y2 + dy[j];
            	int nx2 = blueReach ? x2 : x2 + dx[j];
                
                if (isOut(ny2, nx2)) continue; // 바깥으로 나가면  
                if (walls[ny2][nx2]) continue; // 벽을 만나면 
                if (!blueReach && blueVisited[ny2][nx2]) continue; // 방문한 적이 있으면
                
                if (isSame(ny1, nx1, ny2, nx2)) continue; // 같은 위치로 밀게 되면
                if (isSame(y1, x1, ny2, nx2) && isSame(y2, x2, ny1, nx1)) continue; // 서로의 위치가 스왑 되면 
                dfs(ny1, nx1, ny2, nx2, depth + 1);
            }
        }
        // 그 분기 끝나면 되돌리기 
        redVisited[y1][x1] = false; 
        blueVisited[y2][x2] = false; 
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
    
    public boolean isSame(int y1, int x1, int y2, int x2) {
        if (y1 == y2 && x1 == x2) return true;
        return false; 
    }
    
    public boolean isOut(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= m) return true; 
        return false;
    }
}