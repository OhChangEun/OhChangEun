class Solution {
    int answer = 0;
    int n;
    int MAX_PAIR = 14;
    int LEN = MAX_PAIR * 2; 
    
    public int solution(int n) {
        this.n = n;
        //print(isSame("))(((())"));
        //print(isValid("()(())"));
        //print(isValid("(())())"));
        
        StringBuilder sb = new StringBuilder("(");
        dfs(sb, sb.length(), 0, sb.length());
        return answer;
    }
    
    public void dfs(StringBuilder sb, int open, int close, int len) {
        //print(len + ": " + sb.toString());
        if (len > 2 * n) return; 
        if (open < close) return;
        //print(open + " " + close);
        if (open == close && len == 2 * n) {
            //print(sb.toString());
            answer++;
            return;
        }
        //if ()
        
        dfs(new StringBuilder(sb.append("(")), open + 1, close, len + 1);    
        dfs(new StringBuilder(sb.append(")")), open, close + 1, len + 1);    
    }
    
    public boolean isSame(String str) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') open++;
            else close++;
        }
        
        return (open == close) ? true : false;
    }
    
    public boolean isValid(String str) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') open++;
            else close++;
            
            if (open < close) return false;
        }
        return true;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}