package origin;

public class BSTMap<K extends Comparable<K>,V> implements map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;

        }
        @Override
        public String toString(){
            return key.toString()+":"+ value.toString();
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        size = 0;
        root = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private Node getNode(Node node,K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key)==0)
            return node;
        else if(key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else
            return getNode(node.left,key);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException("Not exits!");
        node.value = newValue;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0)
            node.left = add(node.left,key,value);
        else if(key.compareTo(node.key)>0)
            node.right = add(node.right,key,value);
        else node.value = value;
        return node;
    }

    @Override
    public V remove(K key){
        Node node = getNode(root,key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    public K miniNum(){
        if(size==0){
            throw new IllegalArgumentException("empty");
        }
        return miniNum(root).key;
    }
    private Node miniNum(Node node){
        if(node.left==null)
            return node;
        return miniNum(node.left);
    }

    public K removeMin(){
        K res = miniNum();
        removeMin(root);
        return res;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node remove(Node node,K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }
        else {
            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if(node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node newNode = miniNum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;
            node.left = node.right = null;
            return newNode;
        }
    }

}
