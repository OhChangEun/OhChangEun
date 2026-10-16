import java.util.*;

class Solution {
    
    class Word {
        int start; 
        int end; 
        String word;
        boolean isSpoiler;
        
        public Word(int start, int end, String word) {
            this.start = start;
            this.end = end;
            this.word = word;
            this.isSpoiler = false;
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        
        int n = message.length(); 
        
        List<Word> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder(); 
        int start = 0;
        
        // message 내 모든 단어 좌표 + 단어로 리스트업  
        for (int i = 0; i < n; i++) {
            // 공백만나면 모든 단어  
            char ch = message.charAt(i);
            if (ch == ' ') {
                list.add(new Word(start, i - 1, sb.toString())); 
                start = i + 1; // 다음 단어로 
                sb = new StringBuilder();
                continue;
            }
            sb.append(ch);
        }
        list.add(new Word(start, n - 1, sb.toString())); 
       
        // 스포가 아닌 단어들 Set에 추가 
        Set<String> set = new HashSet<>(); 
        
        int r = spoiler_ranges.length; 
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i); 
            int msgStart = word.start; 
            int msgEnd = word.end; 
            
            for (int j = 0; j < r; j++) {
                int[] range = spoiler_ranges[j];
                int spoStart = range[0];
                int spoEnd = range[1];
            
                if (msgStart <= spoEnd && msgEnd >= spoStart) {
                    word.isSpoiler = true; 
                    break;
                }
                
                if (msgEnd < spoStart) 
                    break; 
            }
            
            if (!word.isSpoiler) {
                set.add(word.word);
            }
        }
      
        int answer = 0;
        for (Word word: list) {
            if (!word.isSpoiler) {
                continue; 
            } 
           
            if (!set.contains(word.word)) {
                set.add(word.word); 
                answer++; 
            }
        }
        
        /*
        for (Word word: list) {
            print(word.start + " ~ " + word.end);
            print(word.word);
        }
        */
        
        return answer;
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}