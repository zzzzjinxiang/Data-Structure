public class Main {

    public static void main(String[] args) {
	// write your code here
        //Array arr = new Array(20);
        Array<Integer> arr = new Array<>();
        for(int i=-1;i<9;i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        //[0,100,1,2,3,4,5,6,7,8,9]

        arr.remove(2);
        System.out.println(arr);

        arr.remove(6);
        System.out.println(arr);

        System.out.println(arr.find(100));
    }
}
