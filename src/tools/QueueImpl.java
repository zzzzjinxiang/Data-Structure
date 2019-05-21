package tools;

public class QueueImpl<E> implements Queue<E> {

    private Array<E> array;

    public QueueImpl(int capacity){
        array = new Array<>(capacity);
    }

    public QueueImpl(){
        this(10);
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void offer(E e){
        array.addLast(e);
    }

    @Override
    public E poll(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("tools.Queue:front->");
        res.append("[");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
