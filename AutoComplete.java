import java.util.*;
import java.io.*;

class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
    
    void insert(String s){
        TrieNode curr = this;
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            if(curr.child[ind]==null){
                curr.child[ind]=new TrieNode();
            }
            curr = curr.child[ind];
        }
        curr.isEnd = true;
    }
    
    boolean search(String s){
        TrieNode curr = this;
        for(int i =0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            if(curr.child[ind]==null){
                return(false);
            }
            curr = curr.child[ind];
        }
        if(curr.isEnd==false){
              findAllWords(curr,"");  
        }
        else{
            return(curr.isEnd);
        }
        return(true);
    }
    
    void findAllWords(TrieNode curr,String word){
        if(curr.isEnd==true){
            System.out.println(word);
            return;
        }
        for(int i=0;i<26;i++){
            if(curr.child[i]!=null){
                findAllWords(curr.child[i],word+((char)(i+'a')));
            }
        }
    }
    
}

public class AutoComplete {
    
    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      while(t-->0){
          int n = Integer.parseInt(br.readLine());
          String[] words = new String[n];
          TrieNode trie = new TrieNode();
          for(int i=0;i<n;i++){
              trie.insert(br.readLine());
          }
          String s = br.readLine();
          trie.search(s);
          
      }
    }
}