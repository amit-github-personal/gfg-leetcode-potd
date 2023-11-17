package com.example.tests;

import com.example.datstructure.trie.trie.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrieTests {

    @Test
    void test_if_trie_data_structure_stores_words_and_find_when_done_valid_search() {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Hi");
        trie.insert("What");
        Assertions.assertTrue(trie.searchWord("Hello"));
    }

    @Test
    void shouldReturnFalseOnInvalidSearch() {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Hi");
        trie.insert("What");
        Assertions.assertFalse(trie.searchWord("Henry"));
    }
    @Test
    void shouldReturnTrueWhenPassedaValidPrefix() {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Hi");
        trie.insert("What");
        Assertions.assertTrue(trie.hasPrefix("Hell"));
    }
}
