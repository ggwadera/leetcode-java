package com.ggwadera.hard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertDeleteGetRandomO1DuplicatesTest {

    @Test
    void test1() {
        var set = new InsertDeleteGetRandomO1Duplicates();
        assertThat(set.insert(1)).isTrue();         // return true since the collection does not contain 1.
                                                        // Inserts 1 into the collection.
        assertThat(set.insert(1)).isFalse();        // return false since the collection contains 1.
                                                        // Inserts another 1 into the collection. Collection now contains [1,1].
        assertThat(set.insert(2)).isTrue();         // return true since the collection does not contain 2.
                                                        // Inserts 2 into the collection. Collection now contains [1,1,2].
        assertThat(set.getRandom()).isIn(1, 2); // getRandom should:
                                                        // - return 1 with probability 2/3, or
                                                        // - return 2 with probability 1/3.
        assertThat(set.remove(1)).isTrue();         // return true since the collection contains 1.
                                                        // Removes 1 from the collection. Collection now contains [1,2].
        assertThat(set.getRandom()).isIn(1, 2); // getRandom should return 1 or 2, both equally likely.
    }

    @Test
    void test2() {
        var set = new InsertDeleteGetRandomO1Duplicates();
        assertThat(set.insert(4)).isTrue();
        assertThat(set.insert(3)).isTrue();
        assertThat(set.insert(4)).isFalse();
        assertThat(set.insert(2)).isTrue();
        assertThat(set.insert(4)).isFalse();
        assertThat(set.remove(4)).isTrue();
        assertThat(set.remove(3)).isTrue();
        assertThat(set.remove(4)).isTrue();
        assertThat(set.remove(4)).isTrue();
    }
}