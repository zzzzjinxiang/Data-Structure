package tools;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length-1);i>=0;i--)
            shiftDown(i);
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("null tree");
        return (index-1)/2;
    }

    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }

    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }

    private void shiftUp(int index){
        while (index >0&& data.get(parent(index)).compareTo(data.get(index))<0){
            data.swap(index,parent(index));
            index = parent(index);
        }
    }

    public E findMax(){
        if(data.getSize()==0)
            throw new IllegalArgumentException("empty");
        return data.get(0);
    }

    public E getTop(){
        E res = findMax();

        data.swap(0,data.getSize()-1);
        data.removeLast();
        shiftDown(0);

        return res;
    }

    private void shiftDown(int index){
        while(leftChild(index)<data.getSize()){
            int j = leftChild(index);
            if(j+1<data.getSize() && data.get(j).compareTo(data.get(j+1))<0){
                j = rightChild(index);
            }
            if(data.get(index).compareTo(data.get(j))>=0)
                break;
            data.swap(index,j);
            index = j;

        }
    }

    public E replace(E e){
        E res = findMax();

        data.set(0,e);
        shiftDown(0);

        return res;
    }

}
