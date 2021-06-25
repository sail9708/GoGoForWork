package nowcoder.Huawei;

import java.io.InputStream;
import java.util.Scanner;

public class HJ1_lengthOfWordInStr {
    public static void main(String[] args) {

    }

    //25ms
    public void function1(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str_split = str.split("\\s+");
        System.out.print(str_split[str_split.length-1].length());
    }

    //5ms
    public void function2() throws Exception{
        InputStream in = System.in;
        char c = (char)in.read();

        int count =0;
        while (c!='\n'){
            if (c == ' '){
                count = 0;
            }else {
                count++;
            }
            c = (char)in.read();
        }
        System.out.println(count);
    }
}
