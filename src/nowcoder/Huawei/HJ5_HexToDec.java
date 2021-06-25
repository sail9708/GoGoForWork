package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ5_HexToDec {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String hex;
        while((hex = bf.readLine())!=null){
            String str = hex.split("x")[1];
            int len = str.length();
            int res = 0;
            for(int i = 0; i<len; i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    res += (str.charAt(i)-'0')*Math.pow(16,len-i-1);
                }else{
                    res += (str.charAt(i)-65+10)*Math.pow(16, len-i-1);
                }
            }
            System.out.println(res);
        }
    }
}
