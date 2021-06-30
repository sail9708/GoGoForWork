package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ15_IntToBinary {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            int num = Integer.valueOf(bf.readLine());
            int count = 0;
            while(num!=0){
                if(num%2 == 1){
                    count++;
                }
                num/=2;
            }
            System.out.print(count);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
