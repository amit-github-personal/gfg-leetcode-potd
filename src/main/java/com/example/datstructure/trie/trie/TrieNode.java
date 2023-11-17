package com.example.datstructure.trie.trie;

public class TrieNode {
    boolean isTerminal = false;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
