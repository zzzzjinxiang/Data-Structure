package origin;

import origin.Queue;

public class CycQueue<E> implements Queue<E> {

    private E[] queue;
    private int front,tail;
    /**
     * @param size
     * size为元素个数
     */
    private int size;

    public CycQueue(int capacity){
        queue = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public CycQueue(){
        this(10);
    }

    public int getCapacity(){
        return queue.length-1;
    }

    @Override
    public boolean isEmpty(){
        return (tail == front);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void offer(E e){
        if((tail+1) % queue.length-1 == front)
            resize(getCapacity()*2);
        queue[tail] = e;
        tail = (tail+1)%queue.length;
        size++;
    }

    @Override
    public E poll(){
        if(isEmpty())
            throw new IllegalArgumentException("empty");
        E res = queue[front];
        queue[front] = null;
        front = (front+1)%queue.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 !=0){
            resize(getCapacity()/2);
        }
        return res;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("empty");
        return queue[front];
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity+1];
        for(int i = 0; i<size;i++){
            newData[i] = queue[(i+front)%queue.length];
        }
        queue = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("origin.Array:size=%d,capacity=%d\n",size,getCapacity()));
        res.append("front-> [");
        for(int i =front;i!=tail;i=(i+1)%queue.length){
            res.append(queue[i]);
            if((i+1)%queue.length!=tail)
                res.append(",");
        }
        res.append("] <-tail");
        return res.toString();
    }
}
