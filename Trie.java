import java.util.HashMap;
import java.util.Map;

public class Trie {
    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;
        TrieNode(){
            children = new HashMap<Character,TrieNode>();
            endOfWord = false;
        }
    }

    static TrieNode root;

    static void insert(String word){
        TrieNode current = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    static boolean search(String word){
        TrieNode current = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null)
                return false;
            current = node;
        }
        return current.endOfWord;
    }

    static void delete(String word){
        delete(root,word,0);
    }

    static boolean delete(TrieNode current,String word,int index){
        if(index == word.length()){
            if(current.endOfWord == false){
                return false;
            }
            else{
                current.endOfWord = false;
            }
            if(current.children.size() == 0){
                return true;
            }
            else{
                return false;
            }
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if(node == null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node,word,index+1);
        if(shouldDeleteCurrentNode){
            current.children.remove(c);
            if(current.children.size() == 0){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if(root == null){
            root = new TrieNode();
        }
        insert("ab");
        insert("abcd");
        insert("efg");
        insert("curr");
        System.out.println(search("ac"));
        delete("ab");
        System.out.println(search("ab"));
    }
}
