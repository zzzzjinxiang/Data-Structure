package tools;

import java.util.HashMap;

public class LRU {

    private class Node{
        private int Value;
        private int key;
        Node prev;
        Node next;
    }
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node first;
    private Node last;

    public LRU(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }
    public void put(int key,int value){
        Node node = map.get(key);
        if(node==null){
            node = new Node();
            node.Value = value;
            node.key = key;
            if(isFull()){
                removeLast();
            }
            addFirst(node);
            map.put(key,node);
        } else{
            node.Value = value;
            moveToHead(node);
        }
    }

    private void addFirst(Node node){
        if(map.isEmpty()){
            first = node;
            last = node;
        } else{
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    private void removeLast(){
        last.prev = null;
        last = null;
    }

    private void moveToHead(Node node){
        if(node==first)
            return ;
        if(node==last){
            last.prev.next = null;
            last = last.prev;
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = first.prev;
        node.next = first.next;
        first.prev = node;
        first = node;
    }

    private boolean isFull(){
        return map.size()==capacity;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null)
            return -1;
        moveToHead(node);
        return map.get(key).Value;
    }

}
