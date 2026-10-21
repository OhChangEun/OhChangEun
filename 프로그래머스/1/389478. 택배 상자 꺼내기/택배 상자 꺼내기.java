class Solution {
    public int solution(int n, int w, int target) {
       
        if (w == 1){ 
            return n - target + 1;
        }
        
        int h = n / w + 1;
        int[][] boxes = new int[h][w];
        
        int num = 1;
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    boxes[i][j] = num;
                    num++;
                    if (num > n) break; 
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    boxes[i][j] = num;
                    num++;
                    if (num > n) break; 
                }
            }
        }
       
        int y = 0, x = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (boxes[i][j] == target) {
                    y = i;
                    x = j;
                    break; 
                }
            }
        }
      
        int answer = 0;
        for (int i = y; i < h; i++) {
            if (boxes[i][x] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void println(Object o) {
        System.out.println(o);
    }
    
    public void print(Object o) {
        System.out.print(o);
    }
}