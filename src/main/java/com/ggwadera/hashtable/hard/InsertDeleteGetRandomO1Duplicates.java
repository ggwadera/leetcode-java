package com.ggwadera.hashtable.hard;

import java.util.*;

/**
 * Solution for <a href="https://leetcode.com/problems/insert-delete-getrandom-o1">380. Insert Delete GetRandom O(1)</a>
 */
public class InsertDeleteGetRandomO1Duplicates {

    private final List<Integer> list;
    private final Map<Integer, Set<Integer>> map;
    private final Random random;

    public InsertDeleteGetRandomO1Duplicates() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        Set<Integer> indices = map.get(val);
        if (indices == null) {
            indices = new LinkedHashSet<>();
        }
        indices.add(list.size());
        map.put(val, indices);
        list.add(val);
        return indices.size() == 1;
    }

    public boolean remove(int val) {
        var indices = map.get(val);
        if (indices == null || indices.size() == 0) return false;
        int index = indices.iterator().next();
        indices.remove(index);
        int lastIndex = list.size() - 1;
        if (index < lastIndex) {
            int last = list.get(lastIndex);
            list.set(index, last);
            var lastIdxs = map.get(last);
            lastIdxs.remove(lastIndex);
            lastIdxs.add(index);
        }
        list.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
