package tools;

import java.util.Random;

public class RandomNum {
    private static Random random = new Random();
    public static double product(){
        return (20-10)*random.nextDouble();
    }
    public static void main(String[] args){
        for(int i=0;i<3;i++)
            System.out.println(product());
    }
}
