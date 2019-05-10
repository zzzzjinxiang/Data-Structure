package origin;

import origin.Stack;
import origin.LinkedList;

public class StackLinked<E> implements Stack<E> {

    private LinkedList<E> list;

    public StackLinked(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop(){
        return list.removeFirst();
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("origin.Stack:top->");
        res.append(list);
        return res.toString();
    }
}
