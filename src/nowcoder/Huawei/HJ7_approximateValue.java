package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ7_approximateValue {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine())!=null){
            int index = str.indexOf(".");
            int a = Integer.valueOf(str.substring(0,index));
            int b = Integer.valueOf(str.substring(index+1, index+2));
            if(b>=5){
                System.out.print(a+1);
            }else{
                System.out.print(a);
            }
        }
    }
}
