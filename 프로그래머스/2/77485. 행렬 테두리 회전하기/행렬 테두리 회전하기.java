class Solution {
    
    int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
       
        map = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = columns * i + j + 1;
            }
        }
       
        int n = queries.length; 
        int[] answer = new int[n];
       
        for (int i = 0; i < n; i++) {
            int sy = queries[i][0] - 1;
            int sx = queries[i][1] - 1;
            int ey = queries[i][2] - 1;
            int ex = queries[i][3] - 1;
            
            int min = getMin(map, sy, sx, ey, ex);
           	answer[i] = min; 
        }
        //printArr(map);
        
        return answer;
    }
    
    public int getMin(int[][] map, int sy, int sx, int ey, int ex) {
       	int min = map[sy][sx]; 
        
        for (int i = sy; i <= ey; i++) {
            for (int j = sx; j <= ex; j++) {
                if (i != sy && i != ey && j != sx && j != ex) continue; 
                
                int num = map[i][j];
                min = Math.min(min, num);
            }
        }
        
        rotate(map, sy, sx, ey, ex);
        
        return min;
    }
    
    // 마지막 숫자를 기억하고(10), 오른쪽으로 민다,
    // (sy, sx) (sy, sx + 1) (sy, ex)
    // (sy + 1, sx) (ey, ex); 
    public void rotate(int[][] map, int sy, int sx, int ey, int ex) {
        // 다음으로 넘길 숫자
        int prev = map[sy][ex];
        // print(prev + "\n");
        
        for (int x = ex; x > sx; x--) {
       		map[sy][x] = map[sy][x - 1]; 
        }
       
       	int next = map[ey][ex];	
        for (int y = ey; y > sy; y--) {
       		map[y][ex] = map[y - 1][ex]; 
        }
        map[sy + 1][ex] = prev;

        prev = map[ey][sx];
        for (int x = sx; x < ex; x++) {
       		map[ey][x] = map[ey][x + 1]; 
        }
        map[ey][ex - 1] = next; 

       	next = map[ey][ex];	
        for (int y = sy; y < ey; y++) {
       		map[y][sx] = map[y + 1][sx]; 
        }
       	map[ey - 1][sx] = prev;
    }
    
    public void printArr(int[][] board) {
       	for (int[] row: board) {
            for (int num: row) {
                print(num + " ");
            }
            print("\n");
        } 
    }
    
    public void print(Object o) {
        System.out.print(o);
    }
    
}