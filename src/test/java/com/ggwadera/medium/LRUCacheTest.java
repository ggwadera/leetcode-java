package com.ggwadera.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    enum Impl {
        SIMPLE {
            @Override
            public LRUCache getImpl(int capacity) {
                return new LRUCache.Simplest(capacity);
            }
        },
        MAP {
            @Override
            public LRUCache getImpl(int capacity) {
                return new LRUCache.LinkedMap(capacity);
            }
        },
        DLLIST {
            @Override
            public LRUCache getImpl(int capacity) {
                return new LRUCache.DoubleLinkedList(capacity);
            }
        };

        public abstract LRUCache getImpl(int capacity);
    }

    @ParameterizedTest
    @EnumSource(Impl.class)
    public void test1(Impl impl) {
        LRUCache cache = impl.getImpl(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        assertThat(cache.get(1)).isEqualTo(1); // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertThat(cache.get(2)).isEqualTo(-1); // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertThat(cache.get(1)).isEqualTo(-1); // return -1 (not found)
        assertThat(cache.get(3)).isEqualTo(3); // return 3
        assertThat(cache.get(4)).isEqualTo(4); // return 4
    }

    @ParameterizedTest
    @EnumSource(Impl.class)
    public void test2(Impl impl) {
        LRUCache cache = impl.getImpl(2);
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(2, 6);
        assertThat(cache.get(1)).isEqualTo(-1);
        cache.put(1, 5);
        cache.put(1, 2);
        assertThat(cache.get(1)).isEqualTo(2);
        assertThat(cache.get(2)).isEqualTo(6);
    }

    @ParameterizedTest
    @EnumSource(Impl.class)
    public void test3(Impl impl) {
        LRUCache cache = impl.getImpl(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertThat(cache.get(1)).isEqualTo(-1);
        assertThat(cache.get(2)).isEqualTo(3);
    }

}