import java.util.*;

class Solution {
    int w, h;
    char[][] map;
    
    int[][] dists;
    int[] dy = { -1, 1, 0, 0 };
    int[] dx = { 0, 0, -1, 1};

    final int INF = 1_000_000_000;
    public int solution(String[] board) {
        this.h = board.length; 
        this.w = board[0].length(); 
        this.map = new char[h][w];
        
        int idx = 0;
        for (String row: board) {
            map[idx++] = row.toCharArray();
        } 
        /*
        for (char[] row: map) {
            for (char ch: row) {
                print(ch + " ");
            }
            println("");
        }
        */ 
        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'R') {
                    answer = bfs(i, j);
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int y, int x) {
        dists = new int[h][w];
        for (int[] d: dists) {
            Arrays.fill(d, INF);
        }
        dists[y][x] = 0;
       
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {y, x}); 
        
        while (!queue.isEmpty()) {
            int[] curr = queue.pop(); 
           
            int cy = curr[0];
            int cx = curr[1];
            
            if (map[cy][cx] == 'G') {
                return dists[cy][cx];
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = cy;
                int nx = cx;
               
                // 여기서 굴러가는 로직 
                // 막다른 길이거나, 벽을 만나거나, 
                int ty = ny;
                int tx = nx;
                while (true) {
                    ty += dy[i];
                    tx += dx[i];
                    
                    boolean isOut = ty < 0 || ty >= h || tx < 0 || tx >= w;
                    if (isOut) {
                        ty -= dy[i];
                        tx -= dx[i];
                        break;
                    }
                    boolean isWall = map[ty][tx] == 'D';
                    if (isWall) {
                        ty -= dy[i];
                        tx -= dx[i];
                        break;
                    }
                    
                }
                ny = ty;
                nx = tx;
                
                // 좌표를 벗어나지 않고, 벽이 아니면서, 방문한적이 없어야 함
                    
                if (dists[ny][nx] == INF) {
                    dists[ny][nx] = Math.min(dists[ny][nx], dists[cy][cx] + 1);
                    queue.offer(new int[] {ny, nx});
                }
            }
        }
        
        return -1;
    }
    
    public void println(Object o) {
        System.out.println(o);
    }
    
    public void print(Object o) {
        System.out.print(o);
    }
    
    // 일반 4방향 bfs를 통해 순회 
    // dists[지금] = dist[이전] + 1
    // 벽을 만날 때까지 굴러가므로 ny, nx를 구하는게 관건 
}