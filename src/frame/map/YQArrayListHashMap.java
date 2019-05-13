package frame.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yunqi
 * @createdTime: 2019/5/13
 * 描述
 */
public class YQArrayListHashMap {
   private List<Entry> tables = new ArrayList<>();

   public void put(Object key, Object value) {
       Entry entry = getEntry(key);
       if (entry == null) {
           Entry entry1 = new Entry(key, value);
           tables.add(entry1);
       }else {
           entry.value = value;
       }
   }
    public void remove(Object key) {
        Entry existEntry = getEntry(key);
        if (existEntry != null) {
            tables.remove(existEntry);
        }
    }
   public Object get(Object key) {
      Entry entry = getEntry(key);
      return entry == null ? null : entry.value;
   }
   private Entry getEntry(Object key) {
       for (Entry entry: tables) {
           if (entry.key.equals(key)) {
               return entry;
           }
       }
       return null;
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
        YQArrayListHashMap hashMap = new YQArrayListHashMap();
        hashMap.put("a", "aaaa");
        hashMap.put("b", "bbbb");
        hashMap.put("b", "vvv");
        hashMap.remove("b");
        System.out.println(hashMap.get("b"));
    }

}

