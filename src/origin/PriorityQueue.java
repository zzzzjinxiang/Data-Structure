package origin;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> heap;

    public PriorityQueue(){
        heap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public void offer(E e) {
        heap.add(e);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public E poll() {
        return heap.getTop();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
