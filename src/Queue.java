public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void offer(E e);
    E poll();
    E getFront();

}
