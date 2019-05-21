package tools;

public class LinkedListMap<K,V> implements map<K,V> {

    private class Node{
        public K k;
        public V v;
        public Node next;

        public Node(K k,V v,Node next){
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k){
            this(k,null,null);
        }

        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return k.toString()+":"+ v.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur!=null){
            if(cur.k.equals(key))
                return cur;
            cur=cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null?null:node.v;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else
            node.v = value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node==null){
            throw new IllegalArgumentException("key doesn't exist");
        }
        node.v = newValue;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.k.equals(key)) {
                break;
            }
            prev= prev.next;
        }
        if(prev.next!=null){
            Node cur = prev.next;
            prev.next = cur.next;
            prev.next = null;
            size--;
            return cur.v;
        }

        return null;
    }
}
