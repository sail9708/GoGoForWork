package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ4_splitString {
    public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str;
    while((str = bf.readLine())!=null){
        int start = 0;
        int len = str.length();
        while(len>8){
            System.out.println(str.substring(start,start+8));
            start+=8;
            len-=8;
        }
        if(len>0){
            System.out.print(str.substring(start,start+len));
            for(int i = 0; i < 8-len; i++){
                System.out.print("0");
            }
            System.out.print("\n");
        }
    }
    ;   }
}
