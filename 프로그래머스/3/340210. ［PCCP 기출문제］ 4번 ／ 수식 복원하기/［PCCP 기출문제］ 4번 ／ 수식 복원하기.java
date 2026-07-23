import java.util.*;

class Solution {
    // 2 ~ 9진법
    // 8 + (12 + 3) = 23 
    //  
    public String[] solution(String[] expressions) {
        final int N = 10; 
        // 가능한 진법 표시 
        
        List<String> list = new ArrayList<>();
        int max = 0;
        for (String ex: expressions) {
            String[] s = ex.split(" ");
           
            String left = s[0];
            String right = s[2];
            String op = s[1];
            
            String result = s[4];   
            
            max = Math.max(max, getMax(left));
            max = Math.max(max, getMax(right));
            
            if (!result.equals("X")) {
                max = Math.max(max, getMax(result));
            } 
        }
        //print(max);
           
        boolean[] visited = new boolean[N]; 
        // 해당 진법은 유효하지 않음 
        for (int i = 0; i <= max; i++) {
            visited[i] = true;
        }
        
        // 유효한 진법 중 계산이 옳은 진법만 표시   
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue; 
            
            for (String ex: expressions) {
                String[] s = ex.split(" ");

                String result = s[4];   
                if (result.equals("X")) continue; 
                
                int left = Integer.parseInt(s[0]);
                int right = Integer.parseInt(s[2]);
                String op = s[1];

                int a = change(left, i);
                int b = change(right, i);
                int c = change(Integer.parseInt(result), i);
                
                int res = op.equals("+") ? a + b : a - b; 
               
                if (res != c) {
                    visited[i] = true; // 진법 계산 결과가 다르면 후보에서 제외임 
                }
            }
        }
        
        for (String ex: expressions) {
            String[] s = ex.split(" ");

            String result = s[4];   
            if (!result.equals("X")) {
                continue; 
            }
            
            int left = Integer.parseInt(s[0]);
            int right = Integer.parseInt(s[2]);
            String op = s[1];
            
            boolean isSame = true;
            int temp = -1;

            // 유효한 진법들 검사해서 해당 진법으로 검사했을 때, 값이 다 같은지 확인 
            for (int i = 0; i < N ; i++) {
                if (visited[i]) continue;
                 
                int a = change(left, i);
                int b = change(right, i);

                int res = op.equals("+") ? a + b : a - b; 

                res = formation(res, i);
                // print(i + ": " + res);
                // res = formation(res, i);
                if (temp == -1) {
                    temp = res;
                    continue;
                }
                if (temp != res) {
                    isSame = false;
                } 
            }
           
            result = isSame ? String.valueOf(temp) : "?";
            
            StringBuilder sb = new StringBuilder();
            sb.append(left + " " + op + " " + right + " = " + result);
            list.add(sb.toString());
        }
      
        int n = list.size();
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = list.get(i); 
        }
        // print(formation(6, 6));
        return answer;
    }
    
    public int formation(int num, int div) {
        if (num == 0) return 0; 
        
        int mok = num;
        StringBuilder sb = new StringBuilder();
        while (mok > 0) {
            int remain = mok % div;
            sb.append(remain);
            
            mok /= div;
        }
        int result = Integer.parseInt(sb.reverse().toString());
        return result;
    }
        
    public int change(int num, int div) {
        int sum = 0; 
        int i = 1;
        while (num > 0) {
            int remain = num % 10; 
            sum += remain * i;
            
            i *= div;
            num /= 10;
        }
        
        return sum;
    }
    
    public int getMax(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            max = Math.max(max, num); 
        }
        return max;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}