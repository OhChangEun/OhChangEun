import java.util.*;

class TrieNode {
    TrieNode[] children; 
    int count; 
   
    public TrieNode() {
        this.children = new TrieNode[26];
       	this.count = 0; 
    }
}

class Solution {
    public int solution(String[] words) {
      	
        TrieNode root = new TrieNode();
       
        for (String word: words) {
            
            TrieNode curr = root;           
            for (char ch: word.toCharArray()) {
                
                int idx = ch - 'a';
                
                if (curr.children[idx] == null) {
                	curr.children[idx] = new TrieNode(); 
                }
                
                curr = curr.children[idx];
                curr.count++;
            } 
        }
       
        //dfs(root, "");
       
        int sum = 0;
        for (String word: words) {
            // 한 글자씩 내려가면서 단어의 끝이거나, count가 1일 때의 단어 길이를 더하고 break 
            TrieNode curr = root;
            
            int n = word.length(); 
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                
                int idx = ch - 'a';
                TrieNode child = curr.children[idx];
              
                if (i == n - 1 || child.count == 1) {
                    sum += i + 1;
                    break;
                }
                
                curr = child;
            }
        }
        
        return sum;
    }
    
    public void dfs(TrieNode node, String prefix) {
       
        for (int i = 0; i < 26; i++) {
        	TrieNode child = node.children[i];
           	if (child == null) continue; 
           
            char ch = (char)(i + 'a');
            print(prefix + ch + ": " + child.count);
               
            dfs(child, prefix + ch);
        }
    }
    
    public void printArr(Object[] arr) {
        for (Object o: arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
    
    public void print(Object o) {
        System.out.println(o);
    }
}

// war warrior word world 
// 단어가 끝나면 그 단어 기준으로 동일한거 몇개 있는지 체크, 
// 단어가 안끝나면 