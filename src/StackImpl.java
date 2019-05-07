public class StackImpl<E> implements Stack<E> {
    Array<E> array;
    public StackImpl(int capacity){
        array = new Array<E>(capacity);
    }

    public StackImpl(){
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

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(',');
        }
        res.append("] <- top");
        return res.toString();
    }
}
