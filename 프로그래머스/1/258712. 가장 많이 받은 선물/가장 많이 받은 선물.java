import java.util.*;

class Solution {
    int n;
    int[][] record;
    
    public int solution(String[] friends, String[] gifts) {
        
        this.n = friends.length; 
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i); 
        }
        
        this.record = new int[n][n];
        for (String gift: gifts) {
            String[] parts = gift.split(" ");
           
            String from = parts[0];
            String to = parts[1];
            
            int fromId = map.get(from);
            int toId = map.get(to);
            
            record[fromId][toId]++;
        }
        
        // 지수 기록 
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int send = getRowIndex(i);
            int taken = getColIndex(i);
           
            index[i] = send - taken;
        }
        /*
        for (int num: index) {
            print(num + " ");
        }
        */
        
        int[] nextMonthGift = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue; 
                
                int send = record[i][j];
                int taken = record[j][i];
                
                if (send > taken) {
                    nextMonthGift[i]++;  
                } else if (send < taken) {
                    nextMonthGift[j]++;  
                } else {
                    // 지수 비교
                    if (index[i] > index[j]) {
                        nextMonthGift[i]++;  
                    } else if (index[i] < index[j]) {
                        nextMonthGift[j]++;  
                    }
                }
            }
        }
       
        /*
        for (int[] row: record) {
            for (int num: row) {
                print(num + " ");
            }
            println("");
        }
        println(map);
        */
        
        int max = 0; 
        for (int gift: nextMonthGift) {
            max = Math.max(max, gift);
        }
        
        return max;
    }
    
    public int getRowIndex(int i) {
        int num = 0; 
        for (int j = 0; j < n; j++) {
            num += record[i][j];
        }
        return num;
    }
    
    public int getColIndex(int j) {
        int num = 0; 
        for (int i = 0; i < n; i++) {
            num += record[i][j];
        }
        return num;
    }
    
    public void println(Object o) {
        System.out.println(o);
    }
    
    public void print(Object o) {
        System.out.print(o);
    }
}