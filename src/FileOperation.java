import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {

    public static boolean readFile(String filename, Array<String> words){
        if(filename==null || words == null ){
            System.out.println("file or word is null");
            return false;
        }

        Scanner scanner;
        try{
            File file = new File(filename);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), StandardCharsets.UTF_8);
                scanner.useLocale(Locale.ENGLISH);
                file.exists();
            }
            else {
                return false;
            }
        }catch (IOException e){
            System.out.println("fail to open file:" + filename);
            return false;
        }


        if(scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents,0);
            for(int i = start+1;i<=contents.length();){
                if(i==contents.length() || !Character.isLetter(contents.charAt(i)))
                {
                    String word = contents.substring(start,i).toLowerCase();
                    words.addLast(word);
                    start = firstCharacterIndex(contents,i);
                    i=start+1;
                }
                else i++;
            }
        }

        return true;
    }

    private static int firstCharacterIndex(String s,int start){
        for(int i = start;i<s.length();i++){
            if(Character.isLetter((s.charAt(i))))
                return i;
        }
        return s.length();
    }

    public static double timeGet(String filename,Set<String> set){
        long startTime = System.nanoTime();
        Array<String> words = new Array<>();
        System.out.println(FileOperation.readFile(filename,words));
        System.out.println("Total words " + words.getSize());

        for(int i=0;i<words.getSize();i++)
            set.add(words.get(i));
        System.out.println(set.getSize());
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
}
