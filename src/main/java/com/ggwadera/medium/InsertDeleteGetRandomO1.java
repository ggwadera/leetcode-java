package com.ggwadera.medium;

import java.util.*;

/**
 * Solution for <a href="https://leetcode.com/problems/insert-delete-getrandom-o1">380. Insert Delete GetRandom O(1)</a>
 */
public class InsertDeleteGetRandomO1 {

    private final List<Integer> list;
    private final Map<Integer, Integer> map;
    private final Random random;

    public InsertDeleteGetRandomO1() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastIndex = list.size() - 1;

        // If the element is not on the last index of the list, swap with the last for O(1) removal
        // Otherwise, all the elements of the list will need to be shifted after removing an element
        if (index < lastIndex) {
            int last = list.get(lastIndex);
            list.set(index, last);
            map.put(last, index);
        }

        list.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
