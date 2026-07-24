class Solution {
    final int SIZE = 3;
   
    public int solution(String[] board) {
		char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
        }
        
        // O 개수보다 X가 많을 경우 
        int oNum = 0;
        int xNum = 0; 
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char ch = map[i][j]; 
                if (ch == '.') continue;
                
                if (ch == 'O') oNum++;
                else xNum++; 
            }
        }

        int gap = oNum - xNum;
		boolean oWin = isWin(map, 'O');
		boolean xWin = isWin(map, 'X');
        // 차이가 터무니 없는 경우 
        if (gap != 0 && gap != 1) return 0;
        
        // O랑 X가 동시에 이긴 경우 
   		if (oWin && xWin) return 0;
        
        // O가 이겼는데 gap이 1이 아닌 경우 
       	if (oWin && gap != 1) return 0;	
        
        // X가 이겼는데 gap이 같지 않은 경우 
       	if (xWin && gap != 0) return 0;	
        
        return 1;
    }
    
    public boolean isWin(char[][] map, char target) {
       	for (int i = 0; i < 3; i++) {
            if ((map[i][0] == target) && (map[i][1] == target) && (map[i][2] == target)) return true;
        } 
       	for (int i = 0; i < 3; i++) {
            if ((map[0][i] == target) && (map[1][i] == target) && (map[2][i] == target)) return true;
        } 
        if (map[0][0] == target && map[1][1] == target && map[2][2] == target) return true;
        if (map[2][0] == target && map[1][1] == target && map[0][2] == target) return true;
       
        return false;
    }
    
    public boolean isAllSame(char a, char b, char c) {
        if (a == b && b == c) return true; 
        return false;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}