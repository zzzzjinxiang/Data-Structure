public interface map<K,V> {

    boolean isEmpty();
    int getSize();
    boolean contains(K key);
    void add(K key,V value);
    V get(K key);
    void set(K key,V newValue);
    V remove(K key);
}
