package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ2_jisuanmozimuchuxiancishu {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for(int i = 0; i< str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(0) ||str1.charAt(i)-32 == str2.charAt(0) ||str1.charAt(i)+32 == str2.charAt(0) ){
                count++;
            }
        }
        System.out.print(count);
    }

    public void optimizedFunction(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char[] chars1 = br.readLine().toCharArray();
            char c1 = br.readLine().toCharArray()[0];
            char c2;
            if (c1 >= 'a') {
                c2 = (char)(c1 - 32);
            } else {
                c2 = (char)(c1 + 32);
            }
            int count = 0;
            for (int i = 0; i<chars1.length; i++){
                if (chars1[i] == c1 || chars1[i] == c2) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {

        }
    }
}
