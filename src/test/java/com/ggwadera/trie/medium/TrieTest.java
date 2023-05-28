package com.ggwadera.trie.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    void testTrie() {
        var trie = new Trie();
        trie.insert("apple");
        assertThat(trie.search("apple")).isTrue();   // return True
        assertThat(trie.search("app")).isFalse();     // return False
        assertThat(trie.startsWith("app")).isTrue(); // return True
        trie.insert("app");
        assertThat(trie.search("app")).isTrue();     // return True
    }
}