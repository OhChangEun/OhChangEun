import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;
       
        // 1 3 5 7
        // 2 2 4 6
        
        // b가 현재 상태에서 지면 어차피 뒤에 가도 진다.
        // 작은 애부터 이길 수 있는 애 찾기. 
        // 2로 이기니까 넘어가고, 3이길 애를 끝까지 찾아. 
    
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
     
        int cnt = 0;
        int idx = 0; // b 인덱스 
        for (int i = 0; i < n; i++) {
            while (idx < n) {
                if (A[i] < B[idx++]) {
                    cnt++;
                    break;
                } 
            }
        }
    
        return cnt;
    }
}