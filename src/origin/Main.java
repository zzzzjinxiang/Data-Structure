package origin;

import tools.FileOperation;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //origin.Stack.origin.Array Test
        //origin.Stack.origin.Array arr = new origin.Stack.origin.Array(20);
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

        //origin.Stack Test
        StackImpl<Integer> stackArray = new StackImpl<>();
        for(int i=0;i<6;i++){
            stackArray.push(i);
        }
        System.out.println(stackArray);
        stackArray.pop();
        System.out.println(stackArray.peek());

        //origin.Queue Test
        QueueImpl<Integer> queue = new QueueImpl<>();
        for(int i=0;i<5;i++)
            queue.offer(i);
        System.out.println(queue);
        System.out.println(queue.getFront());
        queue.poll();
        System.out.println(queue.getFront());

        //origin.LinkedList Test
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

        BSTSet<String> set = new BSTSet<>();
        System.out.println(FileOperation.timeGet("1.txt",set));
        LinkedSet<String> set3 = new LinkedSet<>();
        System.out.println(FileOperation.timeGet("1.txt",set3));

        long startTime = System.nanoTime();
        Array<String> words = new Array<>();
        System.out.println(FileOperation.readFile("1.txt",words));
        System.out.println("Total words " + words.getSize());
        BSTMap<String,Integer> map = new BSTMap<>();

        for(int i=0;i<words.getSize();i++){
            if(map.contains(words.get(i)))
                map.set(words.get(i),map.get(words.get(i)+1));
            else map.add(words.get(i),1);
        }
        System.out.println(map.getSize());
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000000.0);

        int num=1000000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0;i<num;i++)
            heap.add(random.nextInt(Integer.MAX_VALUE));


    }

    public static double testStack(Stack<Integer> stack, int count){
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
