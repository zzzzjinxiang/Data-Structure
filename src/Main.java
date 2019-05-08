import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //Stack.Array Test
        //Stack.Array arr = new Stack.Array(20);
        Array<Integer> arr = new Array<>();
        for(int i=-1;i<9;i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        //[0,100,1,2,3,4,5,6,7,8,9]
        arr.remove(2);
        System.out.println(arr);
        System.out.println(arr.find(100));
        arr.remove(6);
        System.out.println(arr);

        //Stack Test
        StackImpl<Integer> stackArray = new StackImpl<>();
        for(int i=0;i<6;i++){
            stackArray.push(i);
        }
        System.out.println(stackArray);
        stackArray.pop();
        System.out.println(stackArray.peek());

        //Queue Test
        QueueImpl<Integer> queue = new QueueImpl<>();
        for(int i=0;i<5;i++)
            queue.offer(i);
        System.out.println(queue);
        System.out.println(queue.getFront());
        queue.poll();
        System.out.println(queue.getFront());

        //LinkedList Test
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<5;i++){
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2,345);
        list.remove(4);
        list.removeFirst();
        list.removeLast();

        System.out.println(list);

        //StackLinkedList Test
        StackLinked<Integer> listStack = new StackLinked<>();
        for(int i=0;i<5;i++){
            listStack.push(i);
            System.out.println(listStack);
        }
        System.out.println(listStack.pop());
        listStack.pop();
        System.out.println(listStack.peek());
        System.out.println(listStack);

        System.out.println(testStack(stackArray,1000000));
        System.out.println(testStack(listStack,1000000));

        QueueLinkedList<Integer> queueList = new QueueLinkedList<>();
        for(int i=0;i<5;i++){
            queueList.offer(i);
            System.out.println(queueList);
            if(i%3 == 2){
                queueList.poll();
                System.out.println(queueList);
            }

        }
        System.out.println(queueList.getFront());

        BST<Integer> tree = new BST<>();
        for(int i =0; i<10;i++)
            tree.add(i);
        System.out.println(tree);
        tree.remove(6);
        System.out.println(tree);

        long startTime = System.nanoTime();
        Array<String> words = new Array<>();
        System.out.println(FileOperation.readFile("1.txt",words));
        System.out.println("Total words " + words.getSize());
        BSTSet<String> set = new BSTSet<>();

        for(int i=0;i<words.getSize();i++)
            set.add(words.get(i));
        System.out.println(set.getSize());
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000000.0);

        long startTime2 = System.nanoTime();
        ArrayList<String> words2 = new ArrayList<>();
        System.out.println(FileOperation.readFile("1.txt",words2));
        System.out.println("Total words " + words2.size());
        TreeSet<String> set2 = new TreeSet<>();

        for(String word : words2)
            set2.add(word);
        System.out.println(set2.size());
        long endTime2 = System.nanoTime();
        System.out.println((endTime2-startTime2)/1000000000.0);


    }

    public static double testStack(Stack<Integer> stack,int count){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<count;i++)
            stack.push(i);
        for(int i=0;i<count;i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
