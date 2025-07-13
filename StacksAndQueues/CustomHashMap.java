package StacksAndQueues;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }
    private final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = new LinkedList[SIZE];
    }

    private int hash(K key) {
        return (key == null ? 0 : key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int idx = hash(key);
        if (table[idx] == null) table[idx] = new LinkedList<>();
        for (Entry<K, V> entry : table[idx]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[idx].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int idx = hash(key);
        if (table[idx] == null) return null;
        for (Entry<K, V> entry : table[idx]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    public void remove(K key) {
        int idx = hash(key);
        if (table[idx] == null) return;
        table[idx].removeIf(entry -> entry.key.equals(key));
    }
}
