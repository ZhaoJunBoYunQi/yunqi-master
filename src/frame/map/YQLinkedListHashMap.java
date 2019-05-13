package frame.map;

import java.util.LinkedList;

/**
 * @author: yunqi
 * @createdTime: 2019/5/14
 * 描述
 */
public class YQLinkedListHashMap {


    private LinkedList<Entry>[] tabels = new LinkedList[998];

    int size;

    public void put(Object key, Object value) {
        int hash = getHash(key);
        // 判断是否已经在数组中存在
        LinkedList<Entry> list = tabels[hash];
        Entry newEntry = new Entry(key, value);
        if (list == null) {
            // 数组中没有存放元素
            LinkedList<Entry> entries = new LinkedList<>();
            entries.add(newEntry);
            tabels[hash] = entries;
        }else {
            // hashCode 相同情况下 存放在链表后面
            for (Entry entry : list) {
                if (entry.key.equals(key)) {
                    // hashCode相同 对象也相同
                    entry.value = value;
                }else {
                    // hashCode 相同，但是对象不同。
                    list.add(newEntry);
                }
            }
        }
        size++;
    }
    public Object get(Object key) {
        Entry entry = getEntry(key);
        return entry == null ? null : entry.value;
    }
    private int getHash(Object key) {
        int hashCode = key.hashCode();
        int hash = hashCode % tabels.length;
        return hash;
    }
   private Entry getEntry(Object key) {
        int hash = getHash(key);
        LinkedList<Entry> entryList = tabels[hash];
        if (entryList != null) {
            for (Entry entry : entryList) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
   }
    public void remove(Object key) {
        int hash = getHash(key);
        Entry existEntry = getEntry(key);
        if (existEntry != null) {
            tabels[hash].remove();
        }
    }


    class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        YQLinkedListHashMap hashMap = new YQLinkedListHashMap();
        hashMap.put("a", "aaaa");
        hashMap.put("b", "bbbb");
        hashMap.put("b", "vvv");
        hashMap.remove("a");
        System.out.println(hashMap.get("a"));
    }

}
