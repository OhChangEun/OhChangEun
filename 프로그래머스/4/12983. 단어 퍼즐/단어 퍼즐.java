import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
       	int INF = 1_000_000; 
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        /*
        for (int num: dp) {
            print(num + " ");
        }
        */
       
        for (int i = 0; i < n; i++) {
           	if (dp[i] == INF) continue; 
            
            for (String str: strs) {
                int len = str.length(); 
                
                if (i + len <= n && t.startsWith(str, i)) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }
        
        return dp[n] == INF ? -1 : dp[n];
    }
    
    public void print(Object o) {
        System.out.print(o);
    }
    // 1) 완전 탐색으로 매 탐색마다 100개 이하의 단어 중, 
    // 연결해서 첫 시작이 target 단어면 계속 진행 
    // 만약 연결할 수 있는 단어가 없다면 해당 순회는 그만
    // 4번만 돌아도 1억번 아닌가? (100^4)
    // 백트래킹 가지치기는 괜찮은가?
    // => 역시 시간 초과 발생
    
    // 조금더 케이스를 줄여본다면 
    // app > ap, p, pp를 포함하는 중임 
    // 만약 app을 써야 하는 상황이면 ap과 p와 pp를 쓸 이유가 없어진다...? 
    // 그래도 그 뒤에 어떻게 조합될지 모르니 app을 쓰느게 정당한지는 
    // 뒤에 케이스에 따라 달라진다..
   
 	// 2) 메모이제이션을 통해 t의 i번째 글자까지 만들 수 있는 경우를 기록한다. 
    
}