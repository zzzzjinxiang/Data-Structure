package origin;

import origin.Queue;

public class QueueLinkedList<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public QueueLinkedList(){
        head = null;
        tail = null;
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

    @Override
    public void offer(E e) {
        if(tail==null){
            tail = new Node(e);
            head = tail;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E poll() {
        if(isEmpty())
            throw new IllegalArgumentException("empty");
        Node res = head;
        head = head.next;
        res.next = null;
        if(head == null)
            tail =null;
        size--;
        return res.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("empty");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("origin.Queue:->front");
        Node cur = head;
        while(cur!=null){
            res.append(cur.e+"->");
            cur = cur.next;
        }
        res.append("null->tail");
        return res.toString();
    }
}
