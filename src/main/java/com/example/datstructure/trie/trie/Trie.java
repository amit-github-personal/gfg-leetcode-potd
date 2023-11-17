package com.example.datstructure.trie.trie;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        insertUtil(word, temp);
    }

    private void insertUtil(String word, TrieNode node) {
        if(word.length() == 0) {
            node.isTerminal = true;
            return;
        }
        int index = getIndex(word, 0);
        if(node.children[index] == null) {
            node.children[index] = new TrieNode();
        }
        node = node.children[index];
        insertUtil(word.substring(1), node);
    }

    private static int getIndex(String word, int atIndex) {
        int index = 0;
        if(Character.isUpperCase(word.charAt(atIndex))) {
            index = word.charAt(atIndex) - 'A';
        } else {
            index = word.charAt(atIndex) - 'a';
        }
        return index;
    }

    public boolean searchWord(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            int index = getIndex(word, i);
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.isTerminal;
    }

    public boolean hasPrefix(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = getIndex(prefix, i);
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }

}

