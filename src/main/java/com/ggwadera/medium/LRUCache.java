package com.ggwadera.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/lru-cache">146. LRU Cache</a>.
 * There is 3 different solutions provided for this one (more simple to more complex):
 *   1. Simplest - uses the Java Collections framework to handle all the LRU behaviors.
 *   2. LinkedMap - similar to the simplest one, but implementing the LRU behaviors manually.
 *   3. DoubleLinkedList - uses a doubly linked list to keep track of access order.
 */
public interface LRUCache {

    /**
     * Return the value of the key if the key exists, otherwise return -1
     * @return value of the key if exists, otherwise -1
     */
    int get(int key);

    /**
     * Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     */
    void put(int key, int value);

    /**
     * LRU Cache implementation using a LinkedHashMap with the accessOrder property set to true.
     * The removeEldestEntry method makes sure that the least recently used key is removed when the map is full.
     */
    class Simplest implements LRUCache {

        private final Map<Integer, Integer> lru;

        public Simplest(int capacity) {
            this.lru = new LinkedHashMap<>((int) (capacity / 0.75f) + 1, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        @Override
        public int get(int key) {
            return lru.getOrDefault(key, -1);
        }

        @Override
        public void put(int key, int value) {
            lru.put(key, value);
        }
    }

    /**
     * LRU Cache implementation using a LinkedHashMap, and also implementing the LRU behavior in the code.
     */
    class LinkedMap implements LRUCache {
        private final int capacity;
        private final Map<Integer, Integer> lru;

        public LinkedMap(int capacity) {
            this.capacity = capacity;
            this.lru = new LinkedHashMap<>((int) (capacity / 0.75f) + 1);
        }

        public int get(int key) {
            Integer value = lru.get(key);
            if (value == null) return -1;

            // Move this key to the head
            lru.remove(key);
            lru.put(key, value);

            return value;
        }

        public void put(int key, int value) {
            if (lru.containsKey(key)) {
                // Move to head
                lru.remove(key);
            } else if (lru.size() >= capacity) {
                // Remove the least recently used
                var firstKey = lru.keySet().iterator().next();
                lru.remove(firstKey);
            }
            lru.put(key, value);
        }
    }

    /**
     * LRU Cache implementation using a manually implemented doubly linked list. The least recently used entries are
     * kept at the tail of the linked list.
     */
    class DoubleLinkedList implements LRUCache {
        static class DoubleLinkedNode {
            int key, value;
            DoubleLinkedNode previous, next;

            DoubleLinkedNode() {}

            DoubleLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, DoubleLinkedNode> cache;
        private final DoubleLinkedNode head;
        private final DoubleLinkedNode tail;
        private int count = 0;

        public DoubleLinkedList(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>((int) (capacity / 0.75f) + 1);

            this.head = new DoubleLinkedNode();
            this.tail = new DoubleLinkedNode();

            this.head.next = tail;
            this.tail.previous = head;
        }

        public int get(int key) {
            var node = cache.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                var node = cache.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }

            if (count == capacity) {
                var node = popTail();
                cache.remove(node.key);
            } else {
                count += 1;
            }

            var node = new DoubleLinkedNode(key, value);
            addNode(node);
            cache.put(key, node);
        }

        private void addNode(DoubleLinkedNode node) {
            node.previous = head;
            node.next = head.next;
            head.next.previous = node;
            head.next = node;
        }

        private void removeNode(DoubleLinkedNode node) {
            var previous = node.previous;
            var next = node.next;

            previous.next = next;
            next.previous = previous;
        }

        private void moveToHead(DoubleLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DoubleLinkedNode popTail() {
            var node = tail.previous;
            removeNode(node);
            return node;
        }
    }

}
