package com.m2018.january;

import java.util.*;

/**
 * 今天主要想着自己实现一个 hashMap
 * Create by A-mdx at 2018-01-18 00:30
 */
public class Junary17Pro<K, V> extends AbstractMap<K, V> {

    final int linkSize = 1024;
    LinkedList<SimpleEntry<K, V>>[] entrys = new LinkedList[linkSize];
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = key.hashCode() / linkSize;
        if (entrys[index] != null) {
            LinkedList<SimpleEntry<K, V>> links = entrys[index];
            for (SimpleEntry<K, V> link : links) {
                if (link.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() / linkSize;
        if (entrys[index] != null) {
            LinkedList<SimpleEntry<K, V>> links = entrys[index];
            for (SimpleEntry<K, V> link : links) {
                if (link.getKey().equals(key)) {
                    return link.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() / linkSize;
        if (entrys[index] != null) {
            LinkedList<SimpleEntry<K, V>> links = entrys[index];
            for (SimpleEntry<K, V> link : links) {
                if (link.getKey().equals(key)) {
                    V result = link.getValue();
                    link.setValue(value);
                    return result;
                }
            }
            links.add(new SimpleEntry<>(key, value));
        } else {
            LinkedList<SimpleEntry<K, V>> links = new LinkedList<>();
            links.add(new SimpleEntry<>(key, value));
            entrys[index] = links;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() / linkSize;
        if (entrys[index] != null) {
            LinkedList<SimpleEntry<K, V>> links = entrys[index];
            Iterator<SimpleEntry<K, V>> iterator = links.iterator();
            while (iterator.hasNext()) {
                SimpleEntry<K, V> entry = iterator.next();
                if (entry.getKey().equals(key)) {
                    iterator.remove();
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        entrys = new LinkedList[linkSize];
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<SimpleEntry<K, V>> links : entrys) {
            if (links != null) {
                set.addAll(links);
            }
        }
        return set;
    }
}
