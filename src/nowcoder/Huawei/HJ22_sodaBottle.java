package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ22_sodaBottle {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String data;
        while((data = bf.readLine())!=null){
            if(data.equals("0")){
                return;
            }
            int num = Integer.valueOf(data);
            int res = 0;
            while(num>=2){
                if(num == 2){
                    res++;
                    break;
                }
                //可换的汽水数
                int temp1 = num/3;
                res+=temp1;
                //换完后喝掉，手中的空气水瓶数
                num = num-temp1*3+temp1;
            }
            System.out.println(res);
        }
    }
}
