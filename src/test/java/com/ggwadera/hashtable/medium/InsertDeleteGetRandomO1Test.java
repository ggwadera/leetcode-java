package com.ggwadera.hashtable.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertDeleteGetRandomO1Test {

    @Test
    void test() {
        var set = new InsertDeleteGetRandomO1();
        assertThat(set.insert(1)).isTrue(); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertThat(set.remove(2)).isFalse(); // Returns false as 2 does not exist in the set.
        assertThat(set.insert(2)).isTrue(); // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertThat(set.getRandom()).isIn(1, 2); // getRandom() should return either 1 or 2 randomly.
        assertThat(set.remove(1)).isTrue(); // Removes 1 from the set, returns true. Set now contains [2].
        assertThat(set.insert(2)).isFalse(); // 2 was already in the set, so return false.
        assertThat(set.getRandom()).isEqualTo(2); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}