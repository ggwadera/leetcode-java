package com.ggwadera.trie.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordDictionaryTest {

    @Test
    void test1() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        assertThat(wd.search("pad")).isFalse(); // return False
        assertThat(wd.search("bad")).isTrue(); // return True
        assertThat(wd.search(".ad")).isTrue(); // return True
        assertThat(wd.search("b..")).isTrue(); // return True
    }

    @Test
    void test2() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        assertThat(wd.search(".")).isTrue();
        assertThat(wd.search("a")).isTrue();
        assertThat(wd.search("aa")).isFalse();
        assertThat(wd.search("a")).isTrue();
        assertThat(wd.search(".a")).isFalse();
        assertThat(wd.search("a.")).isFalse();
    }

    @Test
    void test3() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        wd.addWord("add");
        assertThat(wd.search("a")).isFalse();
        assertThat(wd.search(".at")).isFalse();
        wd.addWord("bat");
        assertThat(wd.search(".at")).isTrue();
        assertThat(wd.search("an.")).isTrue();
        assertThat(wd.search("a.d.")).isFalse();
        assertThat(wd.search("b.")).isFalse();
        assertThat(wd.search("a.d")).isTrue();
        assertThat(wd.search(".")).isFalse();
    }
}