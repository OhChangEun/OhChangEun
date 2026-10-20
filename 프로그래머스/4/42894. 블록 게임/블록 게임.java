import java.util.*;

class Solution {
//     class Point {
//         int y, x;
        
//         public Point(int y, int x) {
//             this.y = y;
//             this.x = x;
//         }
//     }
//     class Block {
//         int shape; 
//         Point p; 
        
//         public Block(int shape, Point p) {
//             this.shape = shape;
//             this.p = p;
//         }
//     }
    public int getShape(int r, int c) {
        if (r + 1 < n && c + 2 < n) {
            int n = board[r + 1][c];
            if (n != 0) {
                boolean isUnderLineSame = n == board[r + 1][c + 1] 
                                      && n == board[r + 1][c + 2];

                if (board[r][c] == n && isUnderLineSame) return 1; 
                else if (board[r][c + 2] == n && isUnderLineSame) return 2; 
                else if (board[r][c + 1] == n && isUnderLineSame) return 3; 
            }
        }
        if (r + 2 < n && c + 1 < n) {
            int n = board[r + 2][c]; 
            if (n != 0) {
                if (board[r][c] == n 
                    && board[r + 1][c] == n 
                    && board[r + 2][c + 1] == n) return 4; 
                else if (board[r][c + 1] == n 
                    && board[r + 1][c + 1] == n 
                    && board[r + 2][c + 1] == n) return 5;
            } 
        }
        
        return -1;
    }
    
    public boolean isWall(int y, int x) {
        for (int i = 0; i <= y; i++) {
            if (board[i][x] != 0) return true; 
        }
        return false;
    }
        
    int n; 
    int[][] board;
    public int solution(int[][] board) {
      
        this.board = board;
        this.n = board.length;
        
        //List<Block> list = new ArrayList<>();
            
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int shape = getShape(i, j);
                if (shape == -1) continue; 
            }
        }
       
        int answer = 0;
        boolean removed = true;
        while (removed) {
            removed = false; 
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int shape = getShape(i, j);
                    if (shape == -1) continue; 
                    
                    if (tryRemove(shape, i, j)) {
                        answer++;
                        removed = true;
                    }
                }
            }
        }
        
        //print(list);
        
        return answer;
    }
    
    public boolean tryRemove(int shape, int y, int x) {
        if (shape == 1) {
           if (!isWall(y, x + 1) && !isWall(y, x + 2)) {
               board[y][x] = 0;
               board[y + 1][x] = 0;
               board[y + 1][x + 1] = 0;
               board[y + 1][x + 2] = 0;
               
               return true;
           } 
        } else if (shape == 2) {
           if (!isWall(y, x) && !isWall(y, x + 1)) {
               board[y][x + 2] = 0;
               board[y + 1][x] = 0;
               board[y + 1][x + 1] = 0;
               board[y + 1][x + 2] = 0;
               
               return true;
           } 
        } else if (shape == 3) {
           if (!isWall(y, x) && !isWall(y, x + 2)) {
               board[y][x + 1] = 0;
               board[y + 1][x] = 0;
               board[y + 1][x + 1] = 0;
               board[y + 1][x + 2] = 0;
               
               return true; 
           } 
        } else if (shape == 4) {
           if (!isWall(y + 1, x + 1)) {
               board[y][x] = 0;
               board[y + 1][x] = 0;
               board[y + 2][x] = 0;
               board[y + 2][x + 1] = 0;
               
               return true;
           } 
        } else if (shape == 5) {
           if (!isWall(y + 1, x)) {
               board[y][x + 1] = 0;
               board[y + 1][x + 1] = 0;
               board[y + 2][x + 1] = 0;
               board[y + 2][x] = 0;
               
               return true; 
           } 
        }
        
        return false; 
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
    
    // 검은 블록을 떨어뜨려 없앨 수 있는 블록의 개수 최대값 
    // 블록 예제 12개 중에 블록을 떨어뜨려도, 직사각형을 못만든다면 
    // 그 블록은 절대로 없앨 수 없다. 혹은 그 블록으로 가로막고 있어도, 그 아래에 블록들을 없앨 수 없다. 
    
    // 일단 되는 후보: 빨강 3, 4
    // 주황 2, 3, 파랑 1
    // 후보들을 y축 기준으로 정렬해서 
    // 각 후보들의 y축 기준으로 위에 막고 있는게 있으면 못한다고 보고, 
    // 막고 있는게 없으면, 블록 만들었다고 치고, 결과 +1 한 후에 map에서 지우기 
    
    // 문제는 해당 후보를 어떤 방법으로 나타낼거냐 
    // 무슨 블록인지(인덱스), 해당 좌표가 어디인지(맨 왼쪽 위 기준)
    
    // 각 좌표 순회하면서, 리스트에 해당 블록인지 확인되면, 
    // 해당 블록 좌표를 리스트 형태로 넣고, 
    // 리스트 순회하면서 y좌표 검사하면 끝?
    
    // 후보 체크는 일단 각 칸에서 가로 3인 6칸, 가로 2인 6칸 검사를 하드 코딩으로 진행하자
    
    // 1 0 0 
    // 1 1 1 
    
    // 0 1
    // 0 1
    // 1 1
    
    // 1 0 
    // 1 0
    // 1 1
    
    // 0 0 1
    // 1 1 1
    
    // 0 1 0
    // 1 1 1 
    
}